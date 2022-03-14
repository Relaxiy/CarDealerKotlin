package com.example.cars.registration.domain.models

import com.google.gson.annotations.SerializedName

data class PostedUser(
    @SerializedName("username")
    val username: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("birthday")
    val birthday: String,
    @SerializedName("password")
    var password: String?
)
