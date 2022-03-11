package com.example.cars.app.data.api

import com.example.cars.app.domain.models.CarItem
import com.example.cars.app.domain.models.PostItem
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface CarApi {
    @GET("./getCarModels")
    @Headers("Content-Type: application/json")
    fun getCarModels(): Single<List<CarItem>>

    @GET("./posts")
    @Headers("Content-Type: application/json")
    fun getPosts(): Single<List<PostItem>>

    @POST("./posts")
    @Headers("Content-Type: application/json")
    fun sendPost(): Call<PostItem>
}