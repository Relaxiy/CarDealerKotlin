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

    //App Fragments
    fun inject(addCarFragment: AddCarFragment)
    fun inject(carModelsBottomFragment: CarModelsBottomFragment)
    fun inject(carModelsFragment: CarModelsFragment)
    fun inject(favouritePostsFragment: FavouritePostsFragment)
    fun inject(personalPageFragment: PersonalPageFragment)
    fun inject(mainPageFragment: MainPageFragment)

    //App Activities
    fun inject(mainActivity: MainActivity)

    //Registration Activities
    fun inject(loginActivity: LoginActivity)
    fun inject(registerActivity: RegisterActivity)


}