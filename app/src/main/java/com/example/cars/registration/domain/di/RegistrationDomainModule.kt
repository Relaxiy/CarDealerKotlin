package com.example.cars.registration.domain.di

import com.example.cars.registration.data.room.RoomDbInstance
import com.example.cars.registration.data.room.dao.AccountsDao
import com.example.cars.registration.data.room.dao.AccountsDao_Impl
import com.example.cars.registration.domain.interactor.AccountsInteractor
import com.example.cars.registration.domain.interactor.AccountsInteractorImpl
import org.koin.dsl.module

val registrationDomainModule = module {

    single<AccountsDao>{
        AccountsDao_Impl(RoomDbInstance.dataBase)
    }

    single<AccountsInteractor> {
        AccountsInteractorImpl(
            accountsDao = get()
        )
    }
}