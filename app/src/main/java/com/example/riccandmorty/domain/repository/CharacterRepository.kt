package com.example.riccandmorty.domain.repository

import com.example.riccandmorty.domain.models.Character
import com.example.riccandmorty.domain.models.responses.CharacterResponses
import com.example.riccandmorty.util.Resource

interface CharacterRepository {

    suspend fun getCharacters(): Resource<CharacterResponses>

    suspend fun getSelectedCharacter(id:Int):Character
}