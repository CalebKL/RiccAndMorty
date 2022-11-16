package com.example.riccandmorty.domain.models.responses


import com.example.riccandmorty.data.remote.models.CharacterDto
import com.example.riccandmorty.data.remote.models.Info
import com.google.gson.annotations.SerializedName

data class CharacterResponses(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: List<CharacterDto> = emptyList(),

    )