package com.example.cars.app.presentation.recyclers.horizontalRecyclerInAddCar

import android.view.ViewGroup
import android.widget.ImageView
import androidx.activity.result.ActivityResultRegistry
import androidx.recyclerview.widget.RecyclerView

class HorizontalImageAdapter(private val activityResultRegistry: ActivityResultRegistry) : RecyclerView.Adapter<HorizontalImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalImageViewHolder {
        return HorizontalImageViewHolder.newInstance(parent, activityResultRegistry)
    }

    override fun onBindViewHolder(holder: HorizontalImageViewHolder, position: Int) {
        holder.bindItem()
    }

    override fun getItemCount(): Int = 9

}