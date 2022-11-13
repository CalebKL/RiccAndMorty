package com.example.riccandmorty.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.riccandmorty.data.remote.models.Location
import com.example.riccandmorty.data.remote.models.Origin
import com.example.riccandmorty.util.Constants

@Entity(tableName = Constants.CHARACTER_TABLE)
data class CharacterEntity(
    @PrimaryKey(autoGenerate = false)
    val id:Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val status: String
)