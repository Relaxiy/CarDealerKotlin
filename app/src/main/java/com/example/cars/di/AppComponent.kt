package com.example.cars.di

import android.content.Context
import com.example.cars.registration.presentation.login.LoginActivity
import com.example.cars.registration.presentation.register.RegisterActivity
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
        SharedPrefsModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }

    fun viewModelsFactory(): ViewModelFactory

    fun inject(loginActivity: LoginActivity)
    fun inject(registerActivity: RegisterActivity)

}