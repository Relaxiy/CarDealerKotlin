package com.example.cars.app.data.network.models

import com.example.cars.utils.date.CurrentDate
import com.google.gson.annotations.SerializedName

data class PostResponse(
    @SerializedName("images")
    val images: String?,
    @SerializedName("title")
    val title: String,
    @SerializedName("carModel")
    val carModel: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("price")
    val price: String,
    @SerializedName("personName")
    val personName: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("phoneNumber")
    val phoneNumber: String,
    @SerializedName("current_date")
    var date: String = CurrentDate.currentDate
)