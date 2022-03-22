package com.example.cars.registration.domain.di.dagger

import com.example.cars.app.data.api.CarApi
import com.example.cars.registration.data.room.RoomDbInstance
import com.example.cars.registration.data.room.dao.AccountsDao
import dagger.Module
import dagger.Provides

@Module
class DataBaseModule {

    @Provides
    fun provideCarApi() : AccountsDao{
        return RoomDbInstance.dataBase.getAccountsDao()
    }
}