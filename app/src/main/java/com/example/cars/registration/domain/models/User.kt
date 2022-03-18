package com.example.cars.registration.domain.models

data class User(
    val id: Long,
    val username: String,
    val email: String,
    val birthday: String,
    val createdAt: Long
){
    companion object{
        const val UNKNOWN_CREATED_AT = 0L
    }
}