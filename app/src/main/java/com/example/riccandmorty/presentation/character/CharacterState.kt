package com.example.riccandmorty.presentation.character

import com.example.riccandmorty.domain.models.Character


data class CharacterState(
    var isLoading: Boolean = false,
    val characters:List<Character> = emptyList(),
    val error: String = ""
)
