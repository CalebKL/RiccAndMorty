package com.example.riccandmorty.data.repository

import androidx.paging.PagingData
import com.example.riccandmorty.data.local.dao.CharacterDao
import com.example.riccandmorty.data.local.db.MortyDatabase
import com.example.riccandmorty.data.remote.MortyApi
import com.example.riccandmorty.data.remote.models.CharacterDto
import com.example.riccandmorty.domain.models.Character
import com.example.riccandmorty.domain.repository.CharacterRepository
import com.example.riccandmorty.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CharacterRepositoryImp @Inject constructor(
   private val api: MortyApi,
   private val dao: CharacterDao
): CharacterRepository {
    override fun getCharacters(): Flow<Resource<PagingData<Character>>> {
        
    }

    override suspend fun getSelectedCharacter(id: Int): CharacterDto {
        TODO("Not yet implemented")
    }

}