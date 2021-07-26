package com.example.saveomovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.saveomovie.Adapter.UserAdapter
import com.example.saveomovie.Data.Model.DetailsItem
import com.example.saveomovie.viewModel.UserViewModel
import java.util.Collections.emptyList

class MainActivity : AppCompatActivity() {
    private lateinit var userViewModel: UserViewModel
    private lateinit var userAdapter: UserAdapter
    private val dataModelList = emptyList<DetailsItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        setRecyclerAdapter()
        observeLiveData()

    }
    private fun observeLiveData() {
        userViewModel.liveData.observe(this, {
            when (it) {
                is UserUIModel.Success -> {
                    userAdapter.updateList(it.dataModelList)
                    flProgressBar.visibility = View.GONE
                }

                is UserUIModel.Failure -> {
                    Toast.makeText(
                        this@MainActivity,
                        "Error message ${it.error}",
                        Toast.LENGTH_SHORT
                    ).show()
                    flProgressBar.visibility = View.GONE
                }
            }
        })
    }

    /**
     * Sets the recycler view adapter
     */
    private fun setRecyclerAdapter() {
        userAdapter = UserAdapter(dataModelList)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.apply {
            this.layoutManager = layoutManager
            adapter = userAdapter
        }
    }

}