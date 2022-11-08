package com.example.riccandmorty.data.repository.location.remote

import com.example.riccandmorty.domain.models.responses.LocationResponse
import com.example.riccandmorty.util.Resource


interface LocationRemoteDataSource {
    suspend fun getLocation(): Resource<LocationResponse>
}