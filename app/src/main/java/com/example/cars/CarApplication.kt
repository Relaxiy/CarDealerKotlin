package com.example.cars

import android.app.Application
import com.example.cars.app.domain.di.domainModule
import com.example.cars.app.presentation.di.appViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CarApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@CarApplication)
            modules(
                listOf(
                    domainModule,
                    appViewModelModule
                )
            )
        }
    }


}