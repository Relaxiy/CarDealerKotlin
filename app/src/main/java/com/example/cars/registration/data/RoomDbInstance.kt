package com.example.cars.registration.data

import android.content.Context
import androidx.room.Room
import com.example.cars.registration.data.accounts.room.AppDatabase

object RoomDbInstance {

    private lateinit var applicationContext: Context
    private val dataBase: AppDatabase by lazy {
        Room.databaseBuilder(applicationContext, AppDatabase::class.java, "database.db")
            .build()
    }
}