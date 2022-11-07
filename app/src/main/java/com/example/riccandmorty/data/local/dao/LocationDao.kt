package com.example.riccandmorty.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.riccandmorty.domain.models.Location

@Dao
interface LocationDao {
    @Query("SELECT * FROM LOCATION_TABLE ORDER BY id ASC")
    fun getLocation(): PagingSource<Int, Location>

    @Query("SELECT * FROM LOCATION_TABLE  WHERE id =:id")
    fun getSelectedLocation(id: Int): Location

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addLocation(character: List<Location>)

    @Query("SELECT EXISTS (SELECT 1 FROM LOCATION_TABLE WHERE id = :id)")
    suspend fun ifLocationExists(id: Int): Int

    @Query("DELETE FROM LOCATION_TABLE WHERE id =:id")
    suspend fun deleteOneLocation(id: Int)

    @Query("DELETE FROM LOCATION_TABLE")
    suspend fun deleteAllLocations()
}