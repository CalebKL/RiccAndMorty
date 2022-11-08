package com.example.riccandmorty.data.repository.character.remote

import com.example.riccandmorty.data.remote.MortyApi
import com.example.riccandmorty.domain.models.responses.CharacterResponses
import com.example.riccandmorty.util.Resource
import timber.log.Timber
import javax.inject.Inject

class CharacterRemoteImp @Inject constructor(
    private val api: MortyApi
): CharacterRemoteDataSource {
    override suspend fun getCharacters(): Resource<CharacterResponses> {
        val response = api.getCharacters()
        Timber.d("Character Responses", "$response")
        return response
    }
}