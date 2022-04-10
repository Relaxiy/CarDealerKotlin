package com.example.cars.app.presentation.userPosts.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cars.R
import com.example.cars.app.domain.models.UserPost

class UserPostsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    companion object {
        fun newInstance(
            parent: ViewGroup
        ) = UserPostsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.post_item,
                    parent,
                    false
                )
        )
    }

    private val postTitle by lazy {
        itemView.findViewById<TextView>(R.id.post_title)
    }

    private val postPrice by lazy {
        itemView.findViewById<TextView>(R.id.post_price)
    }

    private val postDate by lazy {
        itemView.findViewById<TextView>(R.id.post_date)
    }

    fun bindItem(userPost: UserPost){
        userPost.apply {
            postTitle.text = title
            postPrice.text = price
            postDate.text = date
        }
    }
}