package com.example.riccandmorty.data.repository.location.local

import com.example.riccandmorty.data.local.MortyDatabase
import com.example.riccandmorty.data.repository.location.local.LocationLocalDataSource
import com.example.riccandmorty.domain.models.Location
import javax.inject.Inject

class LocationLocalImpl @Inject constructor(
    private val database: MortyDatabase
): LocationLocalDataSource {
    val dao = database.locationDao()
    override suspend fun getSingleLocation(id: Int): Location {
        return dao.getSelectedLocation(id = id)
    }
}