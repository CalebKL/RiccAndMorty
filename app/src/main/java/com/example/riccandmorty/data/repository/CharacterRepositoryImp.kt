package com.example.riccandmorty.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.riccandmorty.data.local.db.MortyDatabase
import com.example.riccandmorty.data.pagingsource.CharacterRemoteMediator
import com.example.riccandmorty.data.remote.MortyApi
import com.example.riccandmorty.data.remote.models.CharacterDto
import com.example.riccandmorty.domain.models.Character
import com.example.riccandmorty.domain.models.responses.CharacterResponses
import com.example.riccandmorty.domain.repository.CharacterRepository
import com.example.riccandmorty.util.Constants.ITEM_PER_PAGE
import com.example.riccandmorty.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class CharacterRepositoryImp @Inject constructor(
   private val api: MortyApi,
   private val database: MortyDatabase
): CharacterRepository {
    private val dao = database.characterDao()

    override fun getCharacters(): Flow<Resource<PagingData<Character>>> = flow {
        emit(Resource.Loading<PagingData<Character>>())
        try {
            val getCharacterEntity = dao.getCharacters()

        } catch (e: Exception){

        }
    }

    override suspend fun getSelectedCharacter(id: Int): CharacterDto {
        return dao.getSelectedCharacter(id)
    }
}