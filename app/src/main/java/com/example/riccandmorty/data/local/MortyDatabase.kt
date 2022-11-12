package com.example.riccandmorty.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.riccandmorty.data.local.dao.CharacterDao
import com.example.riccandmorty.data.local.dao.CharacterRemoteDao
import com.example.riccandmorty.domain.models.Character
import com.example.riccandmorty.domain.models.CharacterRemoteKeys
import com.example.riccandmorty.domain.models.Location

@Database(
    entities = [Character::class, CharacterRemoteKeys::class],
    version = 1,
    exportSchema = false)
@TypeConverters(LocationConverter::class, OriginConverter::class, ListConverters::class)
abstract class MortyDatabase: RoomDatabase(){
    abstract fun characterDao():CharacterDao
    abstract fun characterRemoteDao():CharacterRemoteDao
}