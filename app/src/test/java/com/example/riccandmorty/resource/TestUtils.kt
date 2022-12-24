package com.example.riccandmorty.resource

import androidx.paging.PagingConfig
import androidx.paging.PagingState
import com.example.riccandmorty.data.remote.models.CharacterDto
import com.example.riccandmorty.data.remote.models.Info
import com.example.riccandmorty.domain.models.responses.CharacterResponses

val validCharacterResult = CharacterResponses(
    info = Info(
        count = 1,
        next = "Two",
        pages = 5,
        prev = "One",
        lastUpdated = null
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

val pagingState = PagingState<Int, CharacterDto>(
    listOf(),
    null,
    PagingConfig(10),
    10
)