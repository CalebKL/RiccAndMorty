package com.example.riccandmorty.domain.repository

import androidx.paging.PagingData
import com.example.riccandmorty.data.remote.models.CharacterDto
import com.example.riccandmorty.domain.models.Character
import com.example.riccandmorty.domain.models.responses.CharacterResponses
import com.example.riccandmorty.util.Resource
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

    fun getCharacters():Flow<Resource<PagingData<Character>>>

    suspend fun getSelectedCharacter(id:Int): CharacterDto
}