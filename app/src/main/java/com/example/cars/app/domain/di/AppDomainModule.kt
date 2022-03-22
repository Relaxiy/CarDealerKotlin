package com.example.cars.app.domain.di

import com.example.cars.app.data.RetrofitInstance
import com.example.cars.app.domain.CarInteractor
import com.example.cars.app.domain.CarInteractorImpl
import org.koin.dsl.module

val domainModule = module {

    single<CarInteractor> {
        CarInteractorImpl(
            repository = RetrofitInstance.getCarApi()
        )
    }

}