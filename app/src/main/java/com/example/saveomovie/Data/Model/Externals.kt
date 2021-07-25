package com.example.saveomovie.Data.Model


import com.google.gson.annotations.SerializedName

data class Externals(
    @SerializedName("imdb")
    val imdb: String,
    @SerializedName("thetvdb")
    val thetvdb: Int,
    @SerializedName("tvrage")
    val tvrage: Any
)