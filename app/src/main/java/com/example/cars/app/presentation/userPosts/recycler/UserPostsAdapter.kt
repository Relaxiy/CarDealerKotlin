package com.example.cars.app.presentation.userPosts.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cars.app.domain.models.UserPost

class UserPostsAdapter : RecyclerView.Adapter<UserPostsViewHolder>() {
    private var items = listOf<UserPost>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserPostsViewHolder {
        return UserPostsViewHolder.newInstance(parent)
    }

    override fun onBindViewHolder(holder: UserPostsViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount() = items.size

    fun setItems(data: List<UserPost>){
        items = data
        notifyDataSetChanged()
    }
}