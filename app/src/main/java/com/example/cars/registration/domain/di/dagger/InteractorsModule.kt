package com.example.cars.registration.domain.di.dagger

import com.example.cars.app.data.api.CarApi
import com.example.cars.app.domain.CarInteractor
import com.example.cars.app.domain.CarInteractorImpl
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
class InteractorsModule {

    @Provides
    @Singleton
    fun provideCarInteractorImpl(carApi: CarApi): CarInteractorImpl = CarInteractorImpl(carApi)

    @Provides
    @Singleton
    fun provideAccountsInteractorImpl(accountsDao: AccountsDao): AccountsInteractorImpl =
        AccountsInteractorImpl(accountsDao)
}