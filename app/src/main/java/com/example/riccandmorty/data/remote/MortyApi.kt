package com.example.riccandmorty.data.remote

import com.example.riccandmorty.domain.models.responses.CharacterResponses
import com.example.riccandmorty.domain.models.responses.LocationResponse
import com.example.riccandmorty.util.Resource
import retrofit2.http.GET
import retrofit2.http.Query

interface MortyApi {

    @GET("character/")
    suspend fun getCharacters(
        @Query("page") page: Int = 0
    ): CharacterResponses

    @GET("location")
    suspend fun getLocation(): Resource<LocationResponse>

}
