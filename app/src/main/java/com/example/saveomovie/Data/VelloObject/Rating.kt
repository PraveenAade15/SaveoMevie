package com.example.saveomovie.Data.VelloObject


import com.google.gson.annotations.SerializedName

data class Rating(
    @SerializedName("average")
    val average: Double
)