package com.example.cars.app.presentation.addPost.bottomSheet.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cars.app.domain.models.CarModel
import com.example.cars.app.presentation.addPost.bottomSheet.recycler.clickListeners.CarModelClickListener

class ModelAdapter(private val carModelClickListener: CarModelClickListener) :
    RecyclerView.Adapter<ModelViewHolder>() {

    private var items: List<CarModel> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder {
        return ModelViewHolder.newInstance(parent, carModelClickListener)
    }

    override fun onBindViewHolder(holder: ModelViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun setItems(data: List<CarModel>) {
        items = data
        notifyDataSetChanged()
    }
}