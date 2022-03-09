package com.example.cars.app.data.api

import com.example.cars.app.domain.models.CarItem
import com.example.cars.app.domain.models.CarModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers

interface CarApi {
    @GET("./getCars")
    @Headers("Content-Type: application/json")
    suspend fun getCars(): Single<List<CarItem>>

    @GET("./getCarModels")
    @Headers("Content-Type: application/json")
    suspend fun getCarModels(): Single<List<CarModel>>
}