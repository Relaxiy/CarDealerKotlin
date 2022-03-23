package com.example.cars.utils.ext

import android.content.Context
import com.example.cars.CarApplication
import com.example.cars.di.AppComponent

val Context.appComponent: AppComponent
    get() = when(this){
        is CarApplication -> appComponent
        else -> this.applicationContext.appComponent
    }
