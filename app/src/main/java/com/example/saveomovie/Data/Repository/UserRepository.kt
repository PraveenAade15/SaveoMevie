package com.example.saveomovie.Data.Repository

import com.example.saveomovie.Data.Network.ApiClient
import com.example.saveomovie.Data.Network.Network
import com.example.saveomovie.Data.Model.DetailsItem
import retrofit2.Callback

class UserRepository(val apiClient: ApiClient) {
    suspend fun getRepositoryResult()=apiClient.getData()


}
