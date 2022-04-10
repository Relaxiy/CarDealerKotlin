package com.example.cars.registration.data.network.api

import com.example.cars.registration.data.network.models.AccountResponse
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface AccountApi {
    @POST("./users")
    @Headers("Content-Type: application/json")
    suspend fun sendAccountToServer(@Body accountResponse: AccountResponse)
}