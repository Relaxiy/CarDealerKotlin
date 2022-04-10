package com.example.cars.app.presentation.carModelsPage.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cars.R
import com.example.cars.app.domain.models.CarItem
import com.example.cars.app.presentation.carModelsPage.recycler.clickListeners.ItemClickListener

class CarViewHolder(
    itemView: View,
    private val itemClickListener: ItemClickListener
) : RecyclerView.ViewHolder(itemView) {
    companion object {
        fun newInstance(parent: ViewGroup, itemClickListener: ItemClickListener) = CarViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.car_models_item,
                    parent,
                    false
                ),
            itemClickListener
        )
    }

    private val carModelLayout by lazy {
        itemView.findViewById<LinearLayout>(R.id.car_model_layout)
    }
    private val carModelTv by lazy {
        itemView.findViewById<TextView>(R.id.car_model_tv)
    }

    private val brandImageIv by lazy {
        itemView.findViewById<ImageView>(R.id.brand_image)
    }

    fun bindItem(item: CarItem) {
        with(item) {
            carModelTv.text = carModel.toString()
        }

        carModelLayout.setOnClickListener {
            itemClickListener.itemClick()
        }
    }
}