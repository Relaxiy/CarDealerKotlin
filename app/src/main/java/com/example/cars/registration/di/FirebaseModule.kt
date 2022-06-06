package com.example.cars.registration.di

import com.example.cars.registration.data.firebase.FirebaseDatabaseManager
import com.example.cars.registration.data.firebase.FirebaseDatabaseManagerImpl
import dagger.Binds
import dagger.Module

@Module
interface FirebaseModule {
    @Binds
    fun bindFirebaseDatabaseManager(firebaseDatabaseManagerImpl: FirebaseDatabaseManagerImpl): FirebaseDatabaseManager
}