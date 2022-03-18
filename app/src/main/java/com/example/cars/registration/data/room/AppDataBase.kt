package com.example.cars.registration.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cars.registration.data.room.models.AccountDbEntity

@Database(
    version = 1,
    entities = [
        AccountDbEntity::class
    ]
)
abstract class AppDataBase : RoomDatabase() {
}