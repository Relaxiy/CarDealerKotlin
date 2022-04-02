package com.example.cars.di

import android.content.Context
import com.example.cars.app.presentation.MainActivity
import com.example.cars.app.presentation.fragments.*
import com.example.cars.registration.presentation.activities.LoginActivity
import com.example.cars.registration.presentation.activities.RegisterActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class,
        InteractorsModule::class,
        RepositoriesModule::class,
        ViewModelsModule::class,
        RoomModule::class,
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }

    fun viewModelsFactory(): ViewModelFactory


}