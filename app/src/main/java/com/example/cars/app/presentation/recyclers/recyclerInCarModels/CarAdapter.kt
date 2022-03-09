package com.example.cars.app.presentation.recyclers.recyclerInCarModels

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cars.app.domain.models.CarItem
import com.example.cars.app.presentation.recyclers.recyclerInCarModels.clickListeners.ItemClickListener

class CarAdapter(private val itemClickListener: ItemClickListener) :
    RecyclerView.Adapter<CarViewHolder>() {

    private var items: List<CarItem> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        return CarViewHolder.newInstance(parent, itemClickListener)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun setItems(data: List<CarItem>) {
        items = data
        notifyDataSetChanged()
    }
}