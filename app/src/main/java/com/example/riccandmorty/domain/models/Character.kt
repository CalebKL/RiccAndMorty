package com.example.riccandmorty.domain.models

import com.example.riccandmorty.data.remote.models.Location
import com.example.riccandmorty.data.remote.models.Origin

data class Character(
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val status: String
    )