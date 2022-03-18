package com.example.cars.registration.data.accounts.room.models

data class Account(
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