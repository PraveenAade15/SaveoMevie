package com.example.saveomovie.Data.Model


import com.google.gson.annotations.SerializedName

data class WebChannel(
    @SerializedName("country")
    val country: Country,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)