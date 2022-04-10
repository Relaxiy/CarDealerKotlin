package com.example.cars.registration.domain.models

data class Account(
    val id: Long,
    val username: String,
    val email: String,
    val birthday: String,
    val password: String,
    val createdAt: String
)