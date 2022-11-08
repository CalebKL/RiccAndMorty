package com.example.riccandmorty.data.repository.character.local

import com.example.riccandmorty.domain.models.Character


interface CharacterLocalDataSource {
    suspend fun getSelectedCharacter(id:Int): Character

}