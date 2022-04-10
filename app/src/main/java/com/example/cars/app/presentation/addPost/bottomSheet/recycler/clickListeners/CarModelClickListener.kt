package com.example.cars.app.presentation.addPost.bottomSheet.recycler.clickListeners

import com.example.cars.app.domain.models.CarModel

interface CarModelClickListener {
    fun carModelClick(carModel: CarModel)
}