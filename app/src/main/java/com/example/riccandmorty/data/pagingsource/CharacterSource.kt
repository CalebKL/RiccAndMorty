package com.example.riccandmorty.data.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.riccandmorty.data.mappers.toCharacterEntity
import com.example.riccandmorty.data.remote.MortyApi
import com.example.riccandmorty.domain.models.Character
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CharacterSource @Inject constructor(
    private val api: MortyApi
): PagingSource<Int, Character>() {
    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        return try {
            val nextPage = params.key ?: 1
            val charactersResponse = api.getCharacters(nextPage)
            val characters = charactersResponse.results.map {
                it.
            }
            LoadResult.Page(
                data = characters,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = if (characters.results.isEmpty()) null else characters.info.pages + 1
            )
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }catch (e:IOException){
            LoadResult.Error(e)
        }
    }
}