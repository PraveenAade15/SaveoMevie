package com.example.saveomovie.Data.Model


import com.google.gson.annotations.SerializedName

data class DetailsItem(
    @SerializedName("score")
    val score: Double,
    @SerializedName("show")
    val show: Show
)