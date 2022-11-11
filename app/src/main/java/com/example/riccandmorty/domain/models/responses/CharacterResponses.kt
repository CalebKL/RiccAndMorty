package com.example.riccandmorty.domain.models.responses


import com.example.riccandmorty.domain.models.Character
import com.example.riccandmorty.domain.models.Info
import com.google.gson.annotations.SerializedName

data class CharacterResponses(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: List<Character> = emptyList(),

)