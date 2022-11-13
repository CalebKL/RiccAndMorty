package com.example.riccandmorty.domain.models.responses


import com.example.riccandmorty.data.remote.models.Info
import com.example.riccandmorty.data.remote.models.Location
import com.google.gson.annotations.SerializedName

data class LocationResponse(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: List<Location>
)