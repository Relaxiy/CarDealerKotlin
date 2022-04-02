package com.example.cars.app.data.network.api

import com.example.cars.app.data.network.models.PostResponse
import com.example.cars.app.data.network.models.CarResponse
import com.example.cars.app.domain.models.PostItem
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface CarApi {
    @GET("./getCarModels")
    @Headers("Content-Type: application/json")
    suspend fun getCarModels(): List<CarResponse>

    @GET("./posts")
    @Headers("Content-Type: application/json")
    suspend fun getPosts(): List<PostItem>

    @POST("./posts")
    @Headers("Content-Type: application/json")
    suspend fun sendPost(@Body postResponse: PostResponse)
}