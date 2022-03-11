package com.example.cars.app.presentation.recyclers.horizontalRecyclerInAddCar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.cars.R

class HorizontalImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    companion object {
        fun newInstance(parent: ViewGroup) = HorizontalImageViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.image_item,
                    parent,
                    false
                )
        )
    }

    private val addImage by lazy {
        itemView.findViewById<ImageView>(R.id.add_image)
    }

    fun bindItem(){
        addImage.setOnClickListener{

        }
    }
}