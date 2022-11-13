package com.example.riccandmorty.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.riccandmorty.data.local.converters.ListConverters
import com.example.riccandmorty.data.local.converters.LocationConverter
import com.example.riccandmorty.data.local.converters.OriginConverter
import com.example.riccandmorty.data.local.dao.CharacterDao
import com.example.riccandmorty.data.local.dao.CharacterRemoteDao
import com.example.riccandmorty.data.remote.models.CharacterDto
import com.example.riccandmorty.domain.models.CharacterRemoteKeys

@Database(
    entities = [CharacterDto::class, CharacterRemoteKeys::class],
    version = 1,
    exportSchema = false)
@TypeConverters(LocationConverter::class, OriginConverter::class, ListConverters::class)
abstract class MortyDatabase: RoomDatabase(){
    abstract fun characterDao():CharacterDao
    abstract fun characterRemoteDao():CharacterRemoteDao
}