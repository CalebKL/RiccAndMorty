package com.example.riccandmorty.data.remote

import com.example.riccandmorty.domain.models.responses.CharacterResponses
import com.example.riccandmorty.domain.models.responses.LocationResponse
import com.example.riccandmorty.util.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface MortyApi {

    @GET("character")
    suspend fun getCharacters(): Flow<Resource<List<CharacterResponses>>>

    @GET("location")
    suspend fun getLocation(): Resource<LocationResponse>

}
