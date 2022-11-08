package com.example.riccandmorty.domain.repository

import com.example.riccandmorty.domain.models.Location
import com.example.riccandmorty.domain.models.responses.LocationResponse
import com.example.riccandmorty.util.Resource


interface LocationRepository {

    suspend fun getLocation(): Resource<LocationResponse>

    suspend fun getSingleLocation(id:Int): Location
}