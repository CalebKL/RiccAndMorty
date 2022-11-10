package com.example.riccandmorty.presentation.character

import com.example.riccandmorty.domain.models.responses.CharacterResponses

data class CharacterState(
    var isLoading: Boolean = false,
    val characters:List<CharacterResponses> = emptyList(),
    val error: String = ""
)
