package com.example.cars.registration.domain.di

import com.example.cars.registration.data.api.UserApi
import com.example.cars.registration.data.repository.UserRepository
import com.example.cars.registration.domain.UserInteractor
import com.example.cars.registration.domain.UserInteractorImpl
import org.koin.dsl.module

val registrationDomainModule = module {
    single<UserInteractor> {
        UserInteractorImpl(
            repository = get()
        )
    }

    single<UserApi> {
        UserRepository()
    }
}