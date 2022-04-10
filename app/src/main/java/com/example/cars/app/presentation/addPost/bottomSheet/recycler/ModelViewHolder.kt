package com.example.cars.app.presentation.addPost.bottomSheet.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.cars.R
import com.example.cars.app.domain.models.CarModel
import com.example.cars.app.presentation.addPost.bottomSheet.recycler.clickListeners.CarModelClickListener

class ModelViewHolder(
    itemView: View,
    private val carModelClickListener: CarModelClickListener
) : RecyclerView.ViewHolder(itemView) {
    companion object {
        fun newInstance(
            parent: ViewGroup,
            carModelClickListener: CarModelClickListener
        ) = ModelViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.item_model_bottom_fragment,
                    parent,
                    false
                ),
            carModelClickListener
        )
    }

    private val bottomSheetTextView by lazy {
        itemView.findViewById<TextView>(R.id.model_bottom_sheet_tv)
    }

    private val rootView by lazy {
        itemView.findViewById<ConstraintLayout>(R.id.root_model)
    }

    fun bindItem(item: CarModel) {
        bottomSheetTextView.text = item.model

        rootView.setOnClickListener {
            carModelClickListener.carModelClick(item)
        }
    }
}