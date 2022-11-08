package com.example.riccandmorty.data.repository.character.remote

import com.example.riccandmorty.domain.models.responses.CharacterResponses
import com.example.riccandmorty.util.Resource


interface CharacterRemoteDataSource {
    suspend fun getCharacters(): Resource<CharacterResponses>
}