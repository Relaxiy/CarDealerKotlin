package com.example.cars

import android.app.Application
import com.example.cars.app.domain.di.domainModule
import com.example.cars.app.presentation.di.appViewModelModule
import com.example.cars.registration.data.room.RoomDbInstance
import com.example.cars.registration.domain.di.dagger.AppComponent
import com.example.cars.registration.domain.di.dagger.DaggerAppComponent
import com.example.cars.registration.domain.di.registrationDomainModule
import com.example.cars.registration.presentation.di.registrationViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CarApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.create()

        RoomDbInstance.init(this)

        startKoin {
            androidContext(this@CarApplication)
            modules(
                listOf(
                    domainModule,
                    appViewModelModule,
                    registrationViewModelModule,
                    registrationDomainModule
                )
            )
        }
    }


}