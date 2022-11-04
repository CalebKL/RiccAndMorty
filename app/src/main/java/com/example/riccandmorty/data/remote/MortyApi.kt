package com.example.riccandmorty.data.remote

import com.example.riccandmorty.domain.models.responses.CharacterResponses
import retrofit2.http.GET

interface MortyApi {

    @GET("character")
    suspend fun getCharacters(): CharacterResponses

    @GET("character")
    suspend fun getLocation(): CharacterResponses
}