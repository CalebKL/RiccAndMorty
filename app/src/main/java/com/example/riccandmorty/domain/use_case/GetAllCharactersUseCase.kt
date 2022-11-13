package com.example.riccandmorty.domain.use_case

import androidx.paging.PagingData
import com.example.riccandmorty.domain.models.Character
import com.example.riccandmorty.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import timber.log.Timber

class GetAllCharactersUseCase(
    val repository: CharacterRepository
){
    suspend operator fun invoke(): Flow<PagingData<Character>> {
        val result = repository.getCharacters()
        Timber.tag("GetAllCharactersUseCase")
        return result
    }
}