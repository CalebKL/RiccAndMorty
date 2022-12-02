package com.example.riccandmorty.data.models

import com.example.riccandmorty.data.remote.MortyApi
import com.example.riccandmorty.data.remote.models.CharacterDto
import com.example.riccandmorty.domain.models.responses.CharacterResponses

class FakeMortyApi: MortyApi{
    override suspend fun getCharacters(page: Int): CharacterResponses {
        TODO("Not yet implemented")
    }

    override suspend fun getSingleCharacter(id: Int): CharacterDto {
        TODO("Not yet implemented")
    }
}