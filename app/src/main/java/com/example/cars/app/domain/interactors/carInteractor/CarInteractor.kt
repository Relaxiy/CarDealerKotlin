package com.example.cars.app.domain.interactors.carInteractor

import com.example.cars.app.data.network.models.PostResponse
import com.example.cars.app.domain.models.CarItem
import com.example.cars.app.domain.models.CarModel
import com.example.cars.app.domain.models.PostItem

interface CarInteractor {
    suspend fun getCars(): List<CarItem>

    suspend fun getCarModels(): List<CarModel>

    suspend fun getPosts(): List<PostItem>

    suspend fun sendPost(postResponse: PostResponse)
}