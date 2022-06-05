package com.example.cars.registration.presentation.utils

interface SharedPreferencesManager {

    fun saveSign(value: Boolean)

    fun getSign() : Boolean

    fun saveEmail(email: String)
    fun savePassword(password: String)
    fun getEmail() : String
    fun getPassword() : String
}