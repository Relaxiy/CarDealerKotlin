package com.example.cars.app.domain.di

import com.example.cars.app.data.repository.CarRepository
import com.example.cars.app.domain.CarInteractor
import com.example.cars.app.domain.CarInteractorImpl
import com.example.cars.app.data.api.CarApi
import org.koin.dsl.module

val domainModule = module {

    single<CarInteractor> {
        CarInteractorImpl(
            repository = get()
        )
    }

    single<CarApi> {
        CarRepository()
    }
}