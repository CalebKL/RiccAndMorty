package com.example.riccandmorty.domain.repository

import com.example.riccandmorty.domain.models.Location
import com.example.riccandmorty.domain.models.responses.LocationResponse


interface LocationRepository {

    suspend fun getLocation(): List<LocationResponse>

    suspend fun getSingleLocation(id:Int): Location
}