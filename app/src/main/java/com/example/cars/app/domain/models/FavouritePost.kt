package com.example.cars.app.domain.models

data class FavouritePost(
    var uid: Long = 0,
    val images: List<String>,
    val title: String,
    val carModel: String,
    val description: String,
    val price: String,
    val personName: String,
    val email: String,
    val phoneNumber: String
)
