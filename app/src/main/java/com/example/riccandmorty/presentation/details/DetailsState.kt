package com.example.riccandmorty.presentation.details

import com.example.riccandmorty.data.remote.models.CharacterDto

data class DetailsState(
    var isLoading: Boolean = false,
    val characters: CharacterDto? = null,
    val error: String = ""
)
