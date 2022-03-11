package com.example.cars.app.presentation.recyclers.recyclerInMainPage

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cars.app.domain.models.PostItem

class PostAdapter : RecyclerView.Adapter<PostViewHolder>() {

    private var items: List<PostItem> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder.newInstance(parent)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun setItems(data: List<PostItem>) {
        items = data
        notifyDataSetChanged()
    }
}