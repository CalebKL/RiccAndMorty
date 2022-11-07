package com.example.riccandmorty.data.local.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface RemoteKeys {
    @Query("SELECT * FROM HERO_REMOTE_KEYS_TABLE WHERE id =:heroId")
    suspend fun getRemoteKeys(heroId:Int): RemoteKeys?

    @Insert(onConflict= OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(heroRemoteKey: List<RemoteKeys>)

    @Query("DELETE FROM HERO_REMOTE_KEYS_TABLE")
    suspend fun deleteAllRemoteKeys()
}