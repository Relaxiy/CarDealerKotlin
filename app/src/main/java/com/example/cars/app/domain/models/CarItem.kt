package com.example.cars.app.domain.models

import com.google.gson.annotations.SerializedName

data class CarItem(
    @SerializedName("carModel")
    val carModel: String?,
    @SerializedName("brandImage")
    val brandImage: Int?
)