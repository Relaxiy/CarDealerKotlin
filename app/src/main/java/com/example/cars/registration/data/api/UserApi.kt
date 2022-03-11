package com.example.cars.registration.data.api

import com.example.cars.registration.domain.models.PostedUser
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface UserApi {
    @Headers("Content-Type: application/json")
    @POST("/users")
    fun sendUser(@Body postedUser: PostedUser): Call<PostedUser>
}