package com.example.riccandmorty.domain.use_case

import androidx.paging.PagingData
import androidx.paging.filter
import androidx.paging.map
import com.example.riccandmorty.domain.models.Character
import com.example.riccandmorty.data.remote.models.toCharacter
import com.example.riccandmorty.domain.repository.CharacterRepository
import com.example.riccandmorty.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAllCharactersUseCase @Inject constructor(
    val repository: CharacterRepository
){
     operator fun invoke(): Flow<Resource<PagingData<Character>>> = flow{
         try {
             emit(Resource.Loading<PagingData<Character>>())
             val response = repository.getCharacters().map{ it.}
             emit(Resource.Success<PagingData<Character>>(response))
         }catch (e: HttpException){
             emit(Resource.Error<PagingData<Character>>(e.localizedMessage?: "An Unexpected Error Occurred"))
         }catch (e: IOException){
             emit(Resource.Error<PagingData<Character>>("Couldn't reach Server, Check your Internet Connection"))
         }
    }
}