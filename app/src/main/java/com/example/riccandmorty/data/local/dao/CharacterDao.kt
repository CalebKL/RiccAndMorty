package com.example.riccandmorty.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.riccandmorty.data.local.entity.CharacterEntity

@Dao
interface CharacterDao {
    @Query("SELECT * FROM CHARACTER_TABLE ORDER BY id ASC")
    fun getCharacters(): PagingSource<Int, CharacterEntity>

    @Query("SELECT * FROM CHARACTER_TABLE  WHERE id =:id")
    suspend fun getSelectedCharacter(id: Int): CharacterEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCharacter(character: List<CharacterEntity>)

    @Query("SELECT EXISTS (SELECT 1 FROM CHARACTER_TABLE WHERE id = :id)")
    suspend fun ifExists(id: Int): Int

    @Query("DELETE FROM CHARACTER_TABLE WHERE id =:id")
    suspend fun deleteOneCharacter(id: Int)

    @Query("DELETE FROM CHARACTER_TABLE")
    suspend fun deleteAllCharacters()
}