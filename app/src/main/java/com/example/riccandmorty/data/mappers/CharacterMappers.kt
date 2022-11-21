package com.example.riccandmorty.data.mappers

import com.example.riccandmorty.data.local.entity.CharacterEntity
import com.example.riccandmorty.data.remote.models.CharacterDto
import com.example.riccandmorty.domain.models.Character

fun CharacterDto.toDomain(): Character {
    return Character(
        id = id,
        image = image,
        location = location,
        name = name,
        origin = origin,
        status = status
    )
}


fun CharacterDto.toCharacterEntity(): CharacterEntity{
    return CharacterEntity(
        id = id,
        image = image,
        location = location,
        name = name,
        origin = origin,
        status = status
    )
}