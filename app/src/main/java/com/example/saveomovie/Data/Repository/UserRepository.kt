package com.example.saveomovie.Data.Repository

import com.example.saveomovie.Data.Network.ApiClient
import com.example.saveomovie.Data.Network.Network
import com.example.saveomovie.Data.Model.DetailsItem
import retrofit2.Callback

class UserRepository(private val callback: Callback<DetailsItem>) {
    fun getListOfModel() {
        val apiClient = Network.getInstance().create(ApiClient::class.java)
        val call=apiClient.getData()
        /*
        Once the response is fetched, navigate the user back to view model as this callback is being implemented
        in the Viewmodel class
         */
        call.enqueue(callback)
    }
}
