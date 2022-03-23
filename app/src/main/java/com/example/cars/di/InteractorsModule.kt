package com.example.cars.di

import com.example.cars.app.data.network.api.CarApi
import com.example.cars.app.domain.interactors.CarInteractorImpl
import com.example.cars.registration.data.room.dao.AccountsDao
import com.example.cars.registration.domain.interactor.AccountsInteractorImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(
    includes = [
        InteractorsBindModule::class
    ]
)
class InteractorsModule