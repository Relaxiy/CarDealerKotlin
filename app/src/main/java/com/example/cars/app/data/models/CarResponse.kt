package com.example.cars.app.data.models

import com.google.gson.annotations.SerializedName

data class CarResponse(
    @SerializedName("carModel")
    val carModel: String?,
    @SerializedName("brandImage")
    val brandImage: Int?
)