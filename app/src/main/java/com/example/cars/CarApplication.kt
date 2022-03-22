package com.example.cars

import android.app.Application
import com.example.cars.registration.data.room.RoomDbInstance
import com.example.cars.di.AppComponent
import com.example.cars.di.DaggerAppComponent


class CarApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.create()

        RoomDbInstance.init(this)

    }


}