package com.example.cars.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cars.registration.data.room.dao.AccountsDao
import com.example.cars.registration.data.room.models.AccountDbEntity

@Database(
    version = 1,
    entities = [
        AccountDbEntity::class
    ]
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getAccountsDao(): AccountsDao
}