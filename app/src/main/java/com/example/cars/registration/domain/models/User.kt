package com.example.cars.registration.domain.models

data class User(
    val username: String,
    val email: String,
    val birthday: String,
    var password: String
)