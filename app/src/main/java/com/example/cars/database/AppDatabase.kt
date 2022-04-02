package com.example.cars.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cars.app.data.room.favouritePosts.dao.FavouritePostsDao
import com.example.cars.app.data.room.favouritePosts.models.FavouritePostEntity
import com.example.cars.app.data.room.userPosts.dao.UserPostsDao
import com.example.cars.app.data.room.userPosts.models.UserPostEntity
import com.example.cars.database.AppDatabase.Companion.DATABASE_VERSION
import com.example.cars.registration.data.room.dao.AccountsDao
import com.example.cars.registration.data.room.models.AccountDbEntity

@Database(
    version = DATABASE_VERSION,
    entities = [
        AccountDbEntity::class,
        FavouritePostEntity::class,
        UserPostEntity::class
    ]
)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val DATABASE_VERSION = 1
    }

    abstract fun getAccountsDao(): AccountsDao

    abstract fun getFavouritePostsDao(): FavouritePostsDao

    abstract fun getUserPostsDao(): UserPostsDao
}