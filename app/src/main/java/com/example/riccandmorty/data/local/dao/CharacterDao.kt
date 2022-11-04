package com.example.riccandmorty.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.riccandmorty.domain.models.Character

@Dao
interface CharacterDao {
    @Query("SELECT * FROM CHARACTER_TABLE ORDER BY id ASC")
    suspend fun getCharacters(): PagingSource<Int, Character>

    @Query("SELECT * FROM CHARACTER_TABLE  WHERE id =:id")
    fun getSelectedCharacter(id: Int):Character

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addCharacter(character: List<Character>)

    @Query("SELECT EXISTS (SELECT 1 FROM CHARACTER_TABLE WHERE id = :id)")
    suspend fun ifExists(id: Int): Int

    @Query("DELETE FROM CHARACTER_TABLE WHERE id =:id")
    suspend fun deleteOneCharacter(id: Int)

    @Query("DELETE FROM CHARACTER_TABLE")
    suspend fun deleteAllCharacters()
}