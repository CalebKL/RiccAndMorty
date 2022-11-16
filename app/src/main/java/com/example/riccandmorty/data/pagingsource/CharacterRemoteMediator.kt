package com.example.riccandmorty.data.pagingsource

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.riccandmorty.data.local.db.MortyDatabase
import com.example.riccandmorty.data.mappers.toCharacterEntity
import com.example.riccandmorty.data.mappers.toDomain
import com.example.riccandmorty.data.remote.MortyApi
import com.example.riccandmorty.data.remote.models.CharacterDto
import com.example.riccandmorty.domain.models.CharacterRemoteKeys
import com.example.riccandmorty.domain.models.Character
import java.lang.Exception
import javax.inject.Inject


@OptIn(ExperimentalPagingApi::class)
class CharacterRemoteMediator @Inject constructor(
    private val api:MortyApi,
    private val database: MortyDatabase
): RemoteMediator<Int, Character>(){
    private val characterDao = database.characterDao()
    private val remoteKeyDao = database.characterRemoteDao()

    override suspend fun initialize(): InitializeAction {
        val currentTime = System.currentTimeMillis()
        val lastUpdated = remoteKeyDao.getRemoteKeys(heroId = 1)?.lastUpdated?:0L
        val cacheTimeout = 1440
        val differenceInMinutes = (currentTime - lastUpdated)/1000/60
        return if (differenceInMinutes.toInt() <=cacheTimeout){
            InitializeAction.SKIP_INITIAL_REFRESH
        }else{
            InitializeAction.LAUNCH_INITIAL_REFRESH
        }
    }

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, Character>,
    ): MediatorResult {
        val page = when(loadType){
            LoadType.REFRESH ->{
                val remoteKeys = getRemoteKeysClosestToCurrentPosition(state)
                remoteKeys?.nextPage?.minus(1)?: 1
            }
            LoadType.PREPEND ->{
                val remoteKeys = getRemoteKeysForFirstItem(state)
                val prevPage = remoteKeys?.prevPage
                    ?:return MediatorResult.Success(endOfPaginationReached = remoteKeys != null)
                prevPage
            }
            LoadType.APPEND ->{
                val remoteKeys = getRemoteKeysForLastTime(state)
                val nextPage = remoteKeys?.nextPage
                    ?: return MediatorResult.Success(endOfPaginationReached = remoteKeys != null)
                nextPage
            }
        }
        return try {
            val response = api.getCharacters(page = page)
            val characters = characterDao.addCharacter(response.results.map { it.toCharacterEntity() })
            if (response.results.isNotEmpty()){
                database.withTransaction {
                    if (loadType == LoadType.REFRESH){
                        characterDao.deleteAllCharacters()
                        remoteKeyDao.deleteAllRemoteKeys()
                    }
                    val prevPage = response.info.prev?.lastIndex
                    val nextPage = response.info.next?.lastIndex
                    val keys = response.results.map {character->
                        CharacterRemoteKeys(
                            id = character.id,
                            prevPage =prevPage,
                            nextPage = nextPage,
                            lastUpdated = response.info.lastUpdated
                        )
                    }
                    remoteKeyDao.addAllRemoteKeys(heroRemoteKey = keys)
                    characterDao.addCharacter(character =  characters)
                }
            }
            MediatorResult.Success(endOfPaginationReached = response.info.next?.lastIndex == null)

        }catch (e: Exception){
            MediatorResult.Error(e)
        }
    }

    private suspend fun getRemoteKeysForLastTime(state: PagingState<Int, Character>
    ): CharacterRemoteKeys?{
        return state.pages.lastOrNull{it.data.isNotEmpty()}?.data?.lastOrNull()?.let {hero ->
            remoteKeyDao.getRemoteKeys(heroId = hero.id)
        }
    }

    private suspend fun getRemoteKeysForFirstItem(state: PagingState<Int, Character>
    ): CharacterRemoteKeys?{
        return state.pages.firstOrNull{ it.data.isNotEmpty() }?.data?.firstOrNull()?.let {hero ->
            remoteKeyDao.getRemoteKeys(heroId = hero.id)
        }
    }

    private suspend fun getRemoteKeysClosestToCurrentPosition(state: PagingState<Int, Character>
    ): CharacterRemoteKeys?{
        return state.anchorPosition?.let { position->
            state.closestItemToPosition(anchorPosition = position)?.id?.let {id->
                remoteKeyDao.getRemoteKeys(heroId = id)
            }
        }
    }
}
