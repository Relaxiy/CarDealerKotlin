package com.example.cars.registration.domain.models

data class SignUpData(
    val username: String,
    val email: String,
    val birthday: String,
    val password: String,
    val repeatPassword: String
)