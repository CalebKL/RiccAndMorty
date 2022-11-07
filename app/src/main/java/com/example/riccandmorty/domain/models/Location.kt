package com.example.riccandmorty.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.riccandmorty.util.Constants.LOCATION_TABLE
import com.google.gson.annotations.SerializedName

@Entity(tableName = LOCATION_TABLE)
data class Location(
    @SerializedName("created")
    val created: String,
    @SerializedName("dimension")
    val dimension: String,
    @SerializedName("id")
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("residents")
    val residents: List<String>,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String
)