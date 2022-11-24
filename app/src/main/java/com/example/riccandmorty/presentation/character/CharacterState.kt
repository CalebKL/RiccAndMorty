package com.example.riccandmorty.presentation.character

import androidx.paging.PagingData
import com.example.riccandmorty.data.remote.models.CharacterDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow


data class CharacterState(
    var isLoading: Boolean = false,
    val characters: Flow<PagingData<CharacterDto>> = emptyFlow(),
    val error: String = ""
)
