package com.example.cars.di

import com.example.cars.app.domain.interactors.CarInteractor
import com.example.cars.app.domain.interactors.CarInteractorImpl
import com.example.cars.registration.domain.interactor.AccountsInteractor
import com.example.cars.registration.domain.interactor.AccountsInteractorImpl
import dagger.Binds
import dagger.Module

@Module
interface InteractorsBindModule {

    @Binds
    fun bindAccountInteractor(accountsInteractorImpl: AccountsInteractorImpl): AccountsInteractor

    @Binds
    fun bindCarInteractor(carInteractorImpl: CarInteractorImpl): CarInteractor
}