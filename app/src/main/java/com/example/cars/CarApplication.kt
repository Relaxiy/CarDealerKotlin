package com.example.cars

import android.app.Application
import com.example.cars.di.AppComponent
import com.example.cars.di.DaggerAppComponent


class CarApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .context(this)
            .build()
    }
}