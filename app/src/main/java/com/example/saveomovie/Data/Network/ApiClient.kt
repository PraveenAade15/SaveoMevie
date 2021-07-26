package com.example.saveomovie.Data.Network

import com.example.saveomovie.Data.Model.DetailsItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiClient {
    @GET("search/shows?q=god")
     suspend fun getData(): Call<List<DetailsItem>>

}