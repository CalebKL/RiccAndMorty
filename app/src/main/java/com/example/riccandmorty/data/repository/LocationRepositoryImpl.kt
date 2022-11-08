package com.example.riccandmorty.data.repository

import com.example.riccandmorty.data.repository.location.local.LocationLocalDataSource
import com.example.riccandmorty.data.repository.location.remote.LocationRemoteDataSource
import com.example.riccandmorty.domain.models.Location
import com.example.riccandmorty.domain.models.responses.LocationResponse
import com.example.riccandmorty.domain.repository.LocationRepository
import com.example.riccandmorty.util.Resource
import javax.inject.Inject

class LocationRepositoryImpl @Inject constructor(
    private val local: LocationLocalDataSource,
    private val remote: LocationRemoteDataSource
):LocationRepository {
    override suspend fun getLocation(): Resource<LocationResponse> {
        return remote.getLocation()
    }

    override suspend fun getSingleLocation(id: Int): Location {
        return local.getSingleLocation(id)
    }
}