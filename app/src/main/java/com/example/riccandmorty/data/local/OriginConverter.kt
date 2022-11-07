package com.example.riccandmorty.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.riccandmorty.domain.models.Location
import com.example.riccandmorty.domain.models.Origin
import com.example.riccandmorty.util.JsonParser
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class OriginConverter(
    private val jsonParser: JsonParser
){
    @TypeConverter
    fun fromOrigin(origin: Origin):String{
        return jsonParser.toJson(
            origin,
            object : TypeToken<Origin>(){}.type
        )
    }

    @TypeConverter
    fun toOriginJson(json:String): Origin {
        return jsonParser.fromJson(
            json,
            object : TypeToken<Origin>(){}.type
        )
    }
}