package com.example.cars.registration.domain.di.dagger

import com.example.cars.app.domain.CarInteractor
import com.example.cars.app.domain.CarInteractorImpl
import com.example.cars.registration.domain.interactor.AccountsInteractor
import com.example.cars.registration.domain.interactor.AccountsInteractorImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
interface InteractorsBindModule {

    @Binds
    fun provideAccountInteractor(accountsInteractorImpl: AccountsInteractorImpl): AccountsInteractor

    @Binds
    fun provideCarInteractor(carInteractorImpl: CarInteractorImpl): CarInteractor
}