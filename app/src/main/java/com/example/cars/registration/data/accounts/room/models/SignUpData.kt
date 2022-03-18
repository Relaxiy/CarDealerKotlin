package com.example.cars.registration.data.accounts.room.models

data class SignUpData(
    val username: String,
    val email: String,
    val password: String,
    val birthday: String,
    val repeatPassword: String
)