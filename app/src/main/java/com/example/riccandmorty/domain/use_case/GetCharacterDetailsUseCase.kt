package com.example.riccandmorty.domain.use_case

import com.example.riccandmorty.data.remote.models.CharacterDto
import com.example.riccandmorty.domain.repository.CharacterRepository
import com.example.riccandmorty.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCharacterDetailsUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    operator fun invoke(id: Int): Flow<Resource<CharacterDto>> = flow{
        emit(Resource.Loading<CharacterDto>())
        when(val characterDetails = repository.getSelectedCharacter(id)){
            is Resource.Success -> emit(characterDetails)
            else ->{
                emit(Resource.Error<CharacterDto>(data = null, message = "Error"))
            }
        }
    }
}