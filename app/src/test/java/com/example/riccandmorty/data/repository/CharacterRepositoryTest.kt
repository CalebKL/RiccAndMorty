package com.example.riccandmorty.data.repository

import androidx.paging.PagingData
import com.example.riccandmorty.data.remote.models.CharacterDto
import com.example.riccandmorty.domain.repository.CharacterRepository
import com.example.riccandmorty.util.Resource
import com.google.common.truth.Truth
import io.mockk.mockk
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Test

class CharacterRepositoryTest {
    companion object{
        fun mockCharacterRepo(
            flow: Flow<PagingData<CharacterDto>> = emptyFlow(),
            resource:  Resource<CharacterDto> = Resource.Loading()
        ) = object : CharacterRepository{
            override fun getCharacters() = flow
            override suspend fun getSelectedCharacter(id: Int) = resource
        }
    }

    // To do.....
    @Test
    fun `get characters, flow, emits characters`() = runBlocking {
        val characterRepo = mockCharacterRepo(
            flow {

            }
        )
    }

    @Test
    fun ` Get Selected Character Loading, Return Resource Loading`()= runBlocking{
        val charactersRepo = mockCharacterRepo(
            resource = Resource.Loading()
        )
        val response = charactersRepo.getSelectedCharacter(787)
        assert(response is Resource.Loading)
    }

    @Test
    fun ` Get Selected Character Success, Return Resource Success + Data`()= runBlocking{
        val characters = mockk<CharacterDto>()
        val charactersRepo = mockCharacterRepo(
            resource = Resource.Success(characters)
        )
        val response = charactersRepo.getSelectedCharacter(787)
        assert(response is Resource.Success)
    }

    @Test
    fun ` Get Selected Character Error, Return Resource Error`()= runBlocking{
        val characters = mockk<CharacterDto>()
        val charactersRepo = mockCharacterRepo(
            resource = Resource.Error("Error Getting Characters", characters)
        )
        val response = charactersRepo.getSelectedCharacter(787)
        assert(response is Resource.Error && response.message == "Error Getting Characters")
    }
}