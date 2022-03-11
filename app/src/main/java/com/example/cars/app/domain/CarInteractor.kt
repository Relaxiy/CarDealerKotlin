package com.example.cars.app.domain

import com.example.cars.app.domain.models.CarItem
import com.example.cars.app.domain.models.CarModel
import com.example.cars.app.domain.models.PostItem

interface CarInteractor {
    suspend fun getCars(): List<CarItem>

    suspend fun getCarModels(): List<CarModel>

    suspend fun getPosts(): List<PostItem>
}