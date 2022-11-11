package com.example.riccandmorty.domain.repository

import com.example.riccandmorty.domain.models.Character
import com.example.riccandmorty.domain.models.responses.CharacterResponses
import com.example.riccandmorty.util.Resource
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

    suspend fun getCharacters(): Flow<List<CharacterResponses>>

    suspend fun getSelectedCharacter(id:Int):Character
}