package com.example.riccandmorty.domain.repository

import androidx.paging.PagingData
import com.example.riccandmorty.data.remote.models.CharacterDto
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

    fun getCharacters():Flow<PagingData<CharacterDto>>

    suspend fun getSelectedCharacter(id:Int): CharacterDto
}