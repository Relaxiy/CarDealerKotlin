package com.example.cars.app.presentation.recyclers.recyclerInMainPage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cars.R
import com.example.cars.app.domain.models.PostItem

class PostViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
    companion object {
        fun newInstance(parent: ViewGroup) = PostViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.post_item,
                    parent,
                    false
                )
        )
    }

    fun bindItem(postItem: PostItem){

    }

}