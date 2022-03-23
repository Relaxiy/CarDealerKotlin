package com.example.cars.di

import com.example.cars.app.presentation.MainActivity
import com.example.cars.app.presentation.fragments.*
import com.example.cars.app.presentation.viewModels.*
import com.example.cars.registration.presentation.registerActivities.LoginActivity
import com.example.cars.registration.presentation.registerActivities.RegisterActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class,
        InteractorsModule::class,
        ViewModelsModule::class,
        RoomModule::class,
        ContextModule::class
    ]
)
interface AppComponent {

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