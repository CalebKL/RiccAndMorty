package com.example.riccandmorty.data.repository

import com.example.riccandmorty.data.local.MortyDatabase
import com.example.riccandmorty.data.remote.MortyApi
import com.example.riccandmorty.domain.models.Location
import com.example.riccandmorty.domain.models.responses.LocationResponse
import com.example.riccandmorty.domain.repository.LocationRepository
import com.example.riccandmorty.util.Resource
import javax.inject.Inject

class LocationRepositoryImpl @Inject constructor(
    private val api: MortyApi,
    private val database: MortyDatabase
):LocationRepository {
    private val dao = database.locationDao()
    override suspend fun getLocation(): Resource<LocationResponse> {
        return api.getLocation()
    }
    override suspend fun getSingleLocation(id: Int): Location {
        return dao.getSelectedLocation(id = id)
    }
}