package com.example.cars.registration.domain.models

import android.provider.ContactsContract

data class SignUpData(
    val username: String,
    val email: String,
    val password: String,
    val birthday: String,
    val repeatPassword: String
)