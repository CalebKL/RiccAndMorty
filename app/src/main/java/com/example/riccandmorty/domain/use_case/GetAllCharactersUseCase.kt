package com.example.riccandmorty.domain.use_case

import com.example.riccandmorty.data.repository.CharacterRepositoryImp
import com.example.riccandmorty.domain.models.responses.CharacterResponses
import com.example.riccandmorty.util.Resource
import kotlinx.coroutines.flow.Flow

class GetAllCharactersUseCase(
    val repository: CharacterRepositoryImp
){
    suspend operator fun invoke(): Flow<Resource<List<CharacterResponses>>> {
        return repository.getCharacters()
    }
}