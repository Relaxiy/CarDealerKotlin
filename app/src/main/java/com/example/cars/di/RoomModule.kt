package com.example.cars.di

import android.content.Context
import androidx.room.Room
import com.example.cars.app.data.room.dao.FavouritePostsDao
import com.example.cars.database.AppDatabase
import com.example.cars.registration.data.room.dao.AccountsDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RoomModule {

    @Provides
    @Singleton
    fun provideAccountsDao(database: AppDatabase): AccountsDao {
        return database.getAccountsDao()
    }

    @Provides
    @Singleton
    fun provideFavouritePostsDao(database: AppDatabase): FavouritePostsDao {
        return database.getFavouritePostsDao()
    }

    @Provides
    @Singleton
    fun provideRoomDataBase(context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "database.db")
            .build()
}