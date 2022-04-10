package com.example.cars.registration.data.network.models

import com.google.gson.annotations.SerializedName

data class AccountResponse(
    @SerializedName("id")
    val id: Long,
    @SerializedName( "username")
    val username: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("birthday")
    val birthday: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("createdAt")
    val createdAt: String
)