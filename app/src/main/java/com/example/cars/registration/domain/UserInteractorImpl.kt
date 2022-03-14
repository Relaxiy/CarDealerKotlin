package com.example.cars.registration.domain

import com.example.cars.registration.data.api.UserApi
import com.example.cars.registration.domain.models.PostedUser
import com.example.cars.registration.domain.models.User

class UserInteractorImpl(private val repository: UserApi) : UserInteractor {
    override suspend fun sendUser(user: User?) {
        if (user != null) {
            repository.sendUser(
                PostedUser(
                    username = user.username,
                    email = user.email,
                    birthday = user.birthday,
                    password = user.password
                )
            )
        }
    }

}