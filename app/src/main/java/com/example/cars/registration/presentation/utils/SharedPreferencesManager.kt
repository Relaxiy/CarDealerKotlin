package com.example.cars.registration.presentation.utils

interface SharedPreferencesManager {

    fun save(key: String, value: Boolean)

    fun get(key: String) : Boolean
}