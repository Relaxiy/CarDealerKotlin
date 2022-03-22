package com.example.cars.registration.domain.di.dagger

import com.example.cars.app.domain.CarInteractor
import com.example.cars.app.presentation.viewModels.*
import dagger.Module
import dagger.Provides

@Module
class ViewModelsModule {
    @Provides
    fun provideAddCarFragmentViewModel(carInteractor: CarInteractor): AddCarFragmentViewModel =
        AddCarFragmentViewModel(carInteractor)

    @Provides
    fun provideCarModelsBottomFragmentViewModel(carInteractor: CarInteractor): CarModelsBottomFragmentViewModel =
        CarModelsBottomFragmentViewModel(carInteractor)

    @Provides
    fun provideCarModelsFragmentViewModel(carInteractor: CarInteractor): CarModelsFragmentViewModel =
        CarModelsFragmentViewModel(carInteractor)

    @Provides
    fun provideFavouriteCarsFragmentViewModel(): FavouriteCarsFragmentViewModel =
        FavouriteCarsFragmentViewModel()

    @Provides
    fun provideMainPageFragmentViewModel(carInteractor: CarInteractor): MainPageFragmentViewModel =
        MainPageFragmentViewModel(carInteractor)

    @Provides
    fun providePersonalPageFragmentViewModel(): PersonalPageFragmentViewModel =
        PersonalPageFragmentViewModel()

    @Provides
    fun provideMainActivityViewModel(): MainActivityViewModel =
        MainActivityViewModel()

}