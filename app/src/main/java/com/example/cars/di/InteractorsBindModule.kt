package com.example.cars.di

import com.example.cars.app.domain.CarInteractor
import com.example.cars.app.domain.CarInteractorImpl
import com.example.cars.registration.domain.interactor.AccountsInteractor
import com.example.cars.registration.domain.interactor.AccountsInteractorImpl
import dagger.Binds
import dagger.Module

@Module
interface InteractorsBindModule {

    @Binds
    fun provideAccountInteractor(accountsInteractorImpl: AccountsInteractorImpl): AccountsInteractor

    @Binds
    fun provideCarInteractor(carInteractorImpl: CarInteractorImpl): CarInteractor
}