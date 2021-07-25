package com.example.saveomovie.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.saveomovie.Data.Model.DetailsItem
import com.example.saveomovie.Data.Model.Show
import com.example.saveomovie.R
import com.example.saveomovie.viewHolder.UserViewHolder

class UserAdapter(private var dataModelList: List<Show>) :
    RecyclerView.Adapter<UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.horizantal, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val dataModel = dataModelList[position]
        holder.setData(dataModel)
    }

    override fun getItemCount(): Int {
        return dataModelList.size
    }

    fun updateList(modelList: List<DetailsItem>) {
        dataModelList = modelList
        notifyDataSetChanged()
    }

}