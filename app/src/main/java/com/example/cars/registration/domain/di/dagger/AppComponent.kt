package com.example.cars.registration.domain.di.dagger

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

    fun provideAddCarFragmentViewModel(): AddCarFragmentViewModel

    fun provideCarModelsBottomFragmentViewModel(): CarModelsBottomFragmentViewModel

    fun provideCarModelsFragmentViewModel(): CarModelsFragmentViewModel

    fun provideFavouriteCarsFragmentViewModel(): FavouriteCarsFragmentViewModel

    fun provideMainPageFragmentViewModel(): MainPageFragmentViewModel

    fun providePersonalPageFragmentViewModel(): PersonalPageFragmentViewModel

    fun provideMainActivityViewModel(): MainActivityViewModel
}