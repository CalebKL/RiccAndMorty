package com.example.riccandmorty.presentation.details

import com.example.riccandmorty.data.remote.models.CharacterDto
import com.example.riccandmorty.domain.use_case.GetCharacterDetailsUseCase
import com.example.riccandmorty.util.Resource
import javax.inject.Inject

class DetailsViewModel @Inject constructor(
    private val useCase: GetCharacterDetailsUseCase
) {
    suspend fun getCharactersDetails(id: Int): Resource<CharacterDto> {
        return useCase(id = id)
    }
}