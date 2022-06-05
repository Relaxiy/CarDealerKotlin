package com.example.cars.registration.di

import com.example.cars.registration.presentation.utils.SharedPreferencesManager
import com.example.cars.registration.presentation.utils.SharedPreferencesManagerImpl
import dagger.Binds
import dagger.Module

@Module
interface SharedPrefsModule {

    @Binds
    fun bindAuthSharedPrefs(sharedPreferencesManagerImpl: SharedPreferencesManagerImpl): SharedPreferencesManager

}