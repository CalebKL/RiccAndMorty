package com.example.riccandmorty.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.riccandmorty.data.remote.models.CharacterDto

@Dao
interface CharacterDao {
    @Query("SELECT * FROM CHARACTER_TABLE ORDER BY id ASC")
    fun getCharacters(): PagingSource<Int, CharacterDto>

    @Query("SELECT * FROM CHARACTER_TABLE  WHERE id =:id")
    suspend fun getSelectedCharacter(id: Int): CharacterDto

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCharacter(character: List<CharacterDto>)

    @Query("SELECT EXISTS (SELECT 1 FROM CHARACTER_TABLE WHERE id = :id)")
    suspend fun ifExists(id: Int): Int

    @Query("DELETE FROM CHARACTER_TABLE WHERE id =:id")
    suspend fun deleteOneCharacter(id: Int)

    @Query("DELETE FROM CHARACTER_TABLE")
    suspend fun deleteAllCharacters()
}