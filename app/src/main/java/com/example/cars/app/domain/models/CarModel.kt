package com.example.cars.app.domain.models

import com.google.gson.annotations.SerializedName

data class CarModel(
    @SerializedName("carModel")
    val model: String?
)