package com.example.riccandmorty.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.riccandmorty.domain.models.Location
import com.example.riccandmorty.util.JsonParser
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class LocationConverter(
    private val jsonParser: JsonParser
) {
    @TypeConverter
    fun fromLocationJson(location: Location):String{
        return jsonParser.toJson(
            location,
            object : TypeToken<Location>(){}.type
        )
    }

    @TypeConverter
    fun toLocationJson(json:String):Location{
        return jsonParser.fromJson(
            json,
            object : TypeToken<Location>(){}.type
        )
    }
}