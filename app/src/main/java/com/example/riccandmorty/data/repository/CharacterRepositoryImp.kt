package com.example.riccandmorty.data.repository

import com.example.riccandmorty.data.repository.character.local.CharacterLocalDataSource
import com.example.riccandmorty.data.repository.character.remote.CharacterRemoteDataSource
import com.example.riccandmorty.domain.models.Character
import com.example.riccandmorty.domain.models.responses.CharacterResponses
import com.example.riccandmorty.domain.repository.CharacterRepository
import com.example.riccandmorty.util.Resource
import javax.inject.Inject

class CharacterRepositoryImp @Inject constructor(
    private val local: CharacterLocalDataSource,
    private val remote: CharacterRemoteDataSource
): CharacterRepository{

    override suspend fun getCharacters(): Resource<CharacterResponses> {
       return remote.getCharacters()
    }
    override suspend fun getSelectedCharacter(id: Int): Character {
        return local.getSelectedCharacter(id)
    }
}