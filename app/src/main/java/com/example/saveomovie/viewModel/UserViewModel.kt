package com.example.saveomovie.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.saveomovie.Data.Model.DetailsItem
import com.example.saveomovie.Data.Model.Show
import com.example.saveomovie.Data.Repository.UserRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel : ViewModel(), Callback<DetailsItem> {

    private val repository = UserRepository(this)

    private val mutableLiveData = MutableLiveData<Show>()

    val liveData: LiveData<Show> = mutableLiveData

    /**
     * This method is called once the response is received from the API
     */
    override fun onResponse(call: Call<DetailsItem>, response: Response<DetailsItem>) {
        response.body()?.let {
            mutableLiveData.value = Show.Success(it.data as List<Show>)
        }
    }

    /**
     * If the API response fails due to some reason this method gets invoked
     */
    override fun onFailure(call: Call<DetailsItem>, t: Throwable) {
        mutableLiveData.value = UserUIModel.Failure(t.message!!)
    }

    /**
     * This method makes an API call to the Repository class where actual API call is made
     */
    fun callAPI() {
        repository.getListOfModel()
    }

}