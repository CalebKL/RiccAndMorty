package com.example.riccandmorty.data.remote

import retrofit2.http.GET

interface MortyApi {

    @GET("/character")
    suspend fun getCharacters()


}