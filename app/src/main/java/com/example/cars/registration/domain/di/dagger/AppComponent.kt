package com.example.cars.registration.domain.di.dagger

import com.example.cars.registration.domain.interactor.AccountsInteractor
import dagger.Component

@Component(
    modules = [
        RegistrationDomainModule::class,
        NetworkModule::class
    ]
)
interface AppComponent {

    fun accountsInteractor(): AccountsInteractor
}