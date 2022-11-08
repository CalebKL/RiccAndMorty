package com.example.riccandmorty.data.repository.character.local

import com.example.riccandmorty.data.local.MortyDatabase
import com.example.riccandmorty.domain.models.Character
import javax.inject.Inject

class CharacterLocalImpl @Inject constructor(
    private val database: MortyDatabase
): CharacterLocalDataSource {
    private val dao = database.characterDao()
    override suspend fun getSelectedCharacter(id: Int): Character {
        return dao.getSelectedCharacter(id)
    }
}