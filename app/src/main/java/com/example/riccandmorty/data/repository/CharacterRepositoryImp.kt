package com.example.riccandmorty.data.repository

import com.example.riccandmorty.data.local.MortyDatabase
import com.example.riccandmorty.data.local.dao.CharacterDao
import com.example.riccandmorty.data.remote.MortyApi
import com.example.riccandmorty.domain.models.Character
import com.example.riccandmorty.domain.models.responses.CharacterResponses
import com.example.riccandmorty.domain.repository.CharacterRepository
import com.example.riccandmorty.util.Resource
import timber.log.Timber
import javax.inject.Inject

class CharacterRepositoryImp @Inject constructor(
    private val api: MortyApi,
    database: MortyDatabase
): CharacterRepository {

    private val dao = database.characterDao()
    override suspend fun getCharacters(): Resource<CharacterResponses> {
        val response = api.getCharacters()
        Timber.d("Character Responses", "$response")
        return response
    }
    override suspend fun getSelectedCharacter(id: Int): Character {
        return dao.getSelectedCharacter(id = id)
    }
}