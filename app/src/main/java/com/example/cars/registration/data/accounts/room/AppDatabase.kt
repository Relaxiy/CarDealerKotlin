package com.example.cars.registration.data.accounts.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cars.registration.data.accounts.room.dao.AccountsDao
import com.example.cars.registration.data.accounts.room.models.AccountDbEntity

@Database(
    version = 1,
    entities = [
        AccountDbEntity::class
    ]
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getAccountsDao(): AccountsDao
}