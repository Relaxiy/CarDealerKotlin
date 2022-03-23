package com.example.cars.di

import android.content.Context
import androidx.room.Room
import com.example.cars.CarApplication
import com.example.cars.registration.data.room.AppDatabase
import com.example.cars.registration.data.room.dao.AccountsDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RoomModule {

    @Provides
    @Singleton
    fun provideRoomAccountsDao(database: AppDatabase): AccountsDao {
        return database.getAccountsDao()
    }

    @Provides
    @Singleton
    fun provideRoomDataBase(context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "database.db")
            .build()
}