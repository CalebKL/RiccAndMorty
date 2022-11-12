package com.example.riccandmorty.domain.use_case

import android.util.Log
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.filter
import com.example.riccandmorty.data.repository.CharacterRepositoryImp
import com.example.riccandmorty.domain.models.Character
import com.example.riccandmorty.domain.models.responses.CharacterResponses
import com.example.riccandmorty.domain.repository.CharacterRepository
import com.example.riccandmorty.util.Resource
import kotlinx.coroutines.flow.*
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException

class GetAllCharactersUseCase(
    val repository: CharacterRepository
){
    suspend operator fun invoke(): Flow<PagingData<Character>>{
        val result = repository.getCharacters()
        Log.d("GetAllCharactersUseCase", "$result")
        return result
    }
}