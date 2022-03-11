package com.example.cars.app.presentation.recyclers.horizontalRecyclerInAddCar

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class HorizontalImageAdapter : RecyclerView.Adapter<HorizontalImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalImageViewHolder {
        return HorizontalImageViewHolder.newInstance(parent)
    }

    override fun onBindViewHolder(holder: HorizontalImageViewHolder, position: Int) {
        holder.bindItem()
    }

    override fun getItemCount(): Int = 7

}