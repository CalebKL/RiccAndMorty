package com.example.riccandmorty.data.repository

import com.example.riccandmorty.data.local.MortyDatabase
import com.example.riccandmorty.data.remote.MortyApi
import com.example.riccandmorty.domain.models.Character
import com.example.riccandmorty.domain.models.responses.CharacterResponses
import com.example.riccandmorty.domain.repository.CharacterRepository
import com.example.riccandmorty.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CharacterRepositoryImp @Inject constructor(
   private val api: MortyApi,
   database: MortyDatabase
): CharacterRepository{
    private val dao = database.characterDao()

    override suspend fun getCharacters(): Flow<Resource<List<CharacterResponses>>> {
       return api.getCharacters()
    }
    override suspend fun getSelectedCharacter(id: Int): Character {
        return dao.getSelectedCharacter(id)
    }
}