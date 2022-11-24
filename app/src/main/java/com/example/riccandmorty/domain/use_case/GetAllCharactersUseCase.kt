package com.example.riccandmorty.domain.use_case

import androidx.paging.PagingData
import com.example.riccandmorty.data.remote.models.CharacterDto
import com.example.riccandmorty.domain.repository.CharacterRepository
import com.example.riccandmorty.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAllCharactersUseCase @Inject constructor(
    val repository: CharacterRepository
) {
    operator fun invoke(): Flow<PagingData<CharacterDto>> {
        return repository.getCharacters()
    }
}