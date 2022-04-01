package com.example.cars.di

import android.content.Context
import androidx.room.Room
import com.example.cars.app.data.room.dao.PostsDao
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
    fun providePostsDao(database: AppDatabase): PostsDao {
        return database.getPostsDao()
    }

    @Provides
    @Singleton
    fun provideRoomDataBase(context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "database.db")
            .build()
}