package com.example.riccandmorty.domain.use_case

import androidx.paging.PagingData
import com.example.riccandmorty.data.remote.models.CharacterDto
import com.example.riccandmorty.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllCharactersUseCase @Inject constructor(
    val repository: CharacterRepository
){
    operator fun invoke(): Flow<PagingData<CharacterDto>>{
        return repository.getCharacters()
    }
}