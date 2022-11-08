package com.example.riccandmorty.data.repository

import com.example.riccandmorty.data.local.MortyDatabase
import com.example.riccandmorty.data.remote.MortyApi
import com.example.riccandmorty.domain.models.Location
import com.example.riccandmorty.domain.models.responses.LocationResponse
import com.example.riccandmorty.domain.repository.LocationRepository
import com.example.riccandmorty.util.Resource
import timber.log.Timber
import javax.inject.Inject

class LocationRepositoryImp @Inject constructor(
    private val api: MortyApi,
    database: MortyDatabase
): LocationRepository{

    private val dao = database.locationDao()
    override suspend fun getLocation(): Resource<LocationResponse> {
        val response = api.getLocation()
        Timber.d("Character Responses", "$response")
        return response
    }

    override suspend fun getSingleLocation(id: Int): Location {
        return dao.getSelectedLocation(id = id)
    }

}