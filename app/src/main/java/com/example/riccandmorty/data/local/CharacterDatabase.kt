package com.example.riccandmorty.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.riccandmorty.data.local.dao.CharacterDao
import com.example.riccandmorty.data.local.dao.LocationDao
import com.example.riccandmorty.domain.models.Character
import com.example.riccandmorty.domain.models.Location

@Database(
    entities = [Character::class, Location::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(LocationConverter::class, ListConverters::class, OriginConverter::class)
abstract class CharacterDatabase: RoomDatabase(){
    abstract fun characterDao():CharacterDao
    abstract fun locationDao():LocationDao
}