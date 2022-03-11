package com.example.cars.registration.domain.models

import com.google.gson.annotations.SerializedName

data class PostedUser(
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("birthday")
    val birthday: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    var password: String?
)
