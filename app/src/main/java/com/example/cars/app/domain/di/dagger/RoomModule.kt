package com.example.cars.app.domain.di.dagger

import com.example.cars.registration.data.room.RoomDbInstance
import com.example.cars.registration.data.room.dao.AccountsDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RoomModule {

    @Provides
    @Singleton
    fun provideRoomCurrencyDataSource() : AccountsDao{
        return RoomDbInstance.dataBase.getAccountsDao()
    }
}