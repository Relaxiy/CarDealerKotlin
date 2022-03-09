package com.example.cars.app.domain

import com.example.cars.app.domain.models.CarItem
import com.example.cars.app.domain.models.CarModel

interface CarInteractor {
    suspend fun getCars(): List<CarItem>

    suspend fun getCarModels(): List<CarModel>
}