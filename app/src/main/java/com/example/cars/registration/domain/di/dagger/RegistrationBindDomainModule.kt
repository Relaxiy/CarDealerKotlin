package com.example.cars.registration.domain.di.dagger

import com.example.cars.registration.domain.interactor.AccountsInteractor
import com.example.cars.registration.domain.interactor.AccountsInteractorImpl
import dagger.Binds
import dagger.Module

@Module
interface RegistrationBindDomainModule {

    @Binds
    fun provideAccountInteractor(accountsInteractorImpl: AccountsInteractorImpl): AccountsInteractor
}