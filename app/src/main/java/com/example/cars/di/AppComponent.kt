package com.example.cars.di

import com.example.cars.app.presentation.MainActivity
import com.example.cars.app.presentation.fragments.*
import com.example.cars.app.presentation.viewModels.*
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class,
        InteractorsModule::class,
        ViewModelsModule::class
    ]
)
interface AppComponent {

    //Fragments
    fun inject(addCarFragment: AddCarFragment)
    fun inject(carModelsBottomFragment: CarModelsBottomFragment)
    fun inject(carModelsFragment: CarModelsFragment)
    fun inject(favouritePostsFragment: FavouritePostsFragment)
    fun inject(personalPageFragment: PersonalPageFragment)
    fun inject(mainPageFragment: MainPageFragment)

    //Activities
    fun inject(mainActivity: MainActivity)

    //ViewModels
    val provideAddCarFragmentViewModel: AddCarFragmentViewModel
    val provideCarModelsBottomFragmentViewModel: CarModelsBottomFragmentViewModel
    val provideCarModelsFragmentViewModel: CarModelsFragmentViewModel
    val provideFavouriteCarsFragmentViewModel: FavouritePostsFragmentViewModel
    val provideMainPageFragmentViewModel: MainPageFragmentViewModel
    val providePersonalPageFragmentViewModel: PersonalPageFragmentViewModel
    val provideMainActivityViewModel: MainActivityViewModel
}