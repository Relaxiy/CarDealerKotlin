package com.example.cars.registration.data.room

import android.content.Context
import androidx.room.Room

object RoomDbInstance {

    private lateinit var applicationContext: Context
    val dataBase: AppDatabase by lazy {
        Room.databaseBuilder(applicationContext, AppDatabase::class.java, "database.db")
            .build()
    }
}