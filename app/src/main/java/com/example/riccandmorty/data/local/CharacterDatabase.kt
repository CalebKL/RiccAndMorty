package com.example.riccandmorty.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.riccandmorty.data.local.dao.CharacterDao
import com.example.riccandmorty.domain.models.Character

@Database(
    entities = [Character::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(DatabaseConverter::class)
abstract class CharacterDatabase: RoomDatabase(){

    abstract fun characterDao():CharacterDao
}