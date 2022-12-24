package com.example.riccandmorty.resource

import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.riccandmorty.data.remote.models.CharacterDto
import com.example.riccandmorty.data.remote.models.Info
import com.example.riccandmorty.data.remote.models.Location
import com.example.riccandmorty.data.remote.models.Origin
import com.example.riccandmorty.domain.models.CharacterRemoteKeys
import com.example.riccandmorty.domain.models.responses.CharacterResponses

val validCharacterResult = CharacterResponses(
    info = Info(
        count = 4,
        next = null,
        pages = 3,
        prev = null,
        lastUpdated =  null
    ),
    results = listOf(CharacterDto(
        created = "12/12/12",
        episode = listOf("one", "two", "three"),
        gender = "male",
        id = 2,
        image = "efiefef",
        location = null,
        name = "Ricky",
        origin = null,
        species = "Human",
        status = "alive",
        type = "random",
        url = "enefefne"
    ))
)

val emptyResult = CharacterResponses(
    info = Info(
        count = 1,
        next = null,
        pages = 5,
        prev = "One",
        lastUpdated = null
    ),
    results = emptyList()
)
val pagingState = PagingState<Int, CharacterDto>(
    listOf(), null, PagingConfig(10), 10)

val fakeCharacterDto = CharacterDto(
    created = "12/12/12",
    episode = listOf("one", "two", "three"),
    gender = "male",
    id = 2,
    image = "efiefef",
    location = Location(
        created = "new",
        dimension = "another",
        id = 1,
        name = "random",
        residents = emptyList(),
        type = "random",
        url = "efef"
    ),
    name = "Ricky",
    origin = Origin(
        name = "Pluto",
        url = "dedede"
    ),
    species = "Human",
    status = "alive",
    type = "random",
    url = "enefefne"
)

val remoteKeys = CharacterRemoteKeys(
    id = 1,
    prevPage = 3,
    nextPage = 4,
    lastUpdated = null
)

