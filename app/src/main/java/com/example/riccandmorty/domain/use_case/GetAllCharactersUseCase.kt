package com.example.riccandmorty.domain.use_case

import com.example.riccandmorty.data.repository.CharacterRepositoryImp
import com.example.riccandmorty.domain.models.responses.CharacterResponses
import com.example.riccandmorty.domain.repository.CharacterRepository
import com.example.riccandmorty.util.Resource
import kotlinx.coroutines.flow.Flow

class GetAllCharactersUseCase(
    val repository: CharacterRepository
){
    suspend operator fun invoke(): Flow<List<CharacterResponses>> {
        return repository.getCharacters()
    }
}