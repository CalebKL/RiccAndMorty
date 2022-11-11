package com.example.riccandmorty.domain.models

import com.google.gson.annotations.SerializedName

data class Info(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: Int? = null,
    @SerializedName("pages")
    val pages: Int,
    @SerializedName("prev")
    val prev: Int? = null,
    @SerializedName("lastUpdated")
    val lastUpdated: Long,
)
