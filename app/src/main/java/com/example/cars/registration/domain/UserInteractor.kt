package com.example.cars.registration.domain

import com.example.cars.registration.domain.models.User

interface UserInteractor {
    suspend fun sendUser(user: User?)
}