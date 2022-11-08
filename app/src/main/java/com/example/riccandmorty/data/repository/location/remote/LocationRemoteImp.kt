package com.example.riccandmorty.data.repository.location.remote

import com.example.riccandmorty.data.remote.MortyApi
import com.example.riccandmorty.data.repository.location.remote.LocationRemoteDataSource
import com.example.riccandmorty.domain.models.responses.LocationResponse
import com.example.riccandmorty.util.Resource
import timber.log.Timber
import javax.inject.Inject

class LocationRemoteImp @Inject constructor(
    private val api: MortyApi
): LocationRemoteDataSource {
    override suspend fun getLocation(): Resource<LocationResponse> {
        val response = api.getLocation()
        Timber.d("Character Responses", "$response")
        return response
    }
}