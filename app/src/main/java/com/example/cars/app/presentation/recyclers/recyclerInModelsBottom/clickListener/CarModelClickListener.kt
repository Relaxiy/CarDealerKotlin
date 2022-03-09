package com.example.cars.app.presentation.recyclers.recyclerInModelsBottom.clickListener

import com.example.cars.app.domain.models.CarModel

interface CarModelClickListener {
    fun carModelClick(carModel: CarModel)
}