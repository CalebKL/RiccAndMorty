package com.example.riccandmorty.data.local

import androidx.room.TypeConverter
import com.example.riccandmorty.domain.models.Location
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object LocationConverter{
    private val gson = Gson()
    @TypeConverter
    fun fromLocationJson(location: Location):String{
        return gson.toJson(
            location,
            object : TypeToken<Location>(){}.type
        )
    }

    @TypeConverter
    fun toLocationJson(json:String):Location{
        return gson.fromJson(
            json,
            object : TypeToken<Location>(){}.type
        )
    }
}