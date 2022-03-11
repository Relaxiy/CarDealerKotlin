package com.example.cars.registration.domain.models

data class User(
    val firstName: String,
    val lastName: String,
    val birthday: String,
    val email: String,
    var password: String?
)