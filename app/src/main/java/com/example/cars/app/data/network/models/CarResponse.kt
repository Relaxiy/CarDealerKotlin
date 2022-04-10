package com.example.cars.app.data.network.models

import com.google.gson.annotations.SerializedName

data class CarResponse(
    @SerializedName("carModel")
    val carModel: String?
)