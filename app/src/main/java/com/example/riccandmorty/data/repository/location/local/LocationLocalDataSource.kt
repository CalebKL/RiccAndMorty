package com.example.riccandmorty.data.repository.location.local

import com.example.riccandmorty.domain.models.Location

interface LocationLocalDataSource {
    suspend fun getSingleLocation(id:Int): Location
}