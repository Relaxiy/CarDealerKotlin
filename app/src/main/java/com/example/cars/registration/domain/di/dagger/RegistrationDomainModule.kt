package com.example.cars.registration.domain.di.dagger

import com.example.cars.registration.data.room.dao.AccountsDao
import com.example.cars.registration.domain.interactor.AccountsInteractorImpl
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        RegistrationBindDomainModule::class,
        DataBaseModule::class
    ]
)
class RegistrationDomainModule {

    @Provides
    fun provideAccountsInteractorImpl(accountsDao: AccountsDao): AccountsInteractorImpl {
        return AccountsInteractorImpl(
            accountsDao = accountsDao
        )
    }

}