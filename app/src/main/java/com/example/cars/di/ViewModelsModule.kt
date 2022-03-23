package com.example.cars.di

import com.example.cars.app.domain.CarInteractor
import com.example.cars.app.presentation.viewModels.*
import com.example.cars.registration.domain.interactor.AccountsInteractor
import com.example.cars.registration.presentation.viewModels.LoginActivityViewModel
import com.example.cars.registration.presentation.viewModels.RegisterActivityViewModel
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
    fun provideFavouriteCarsFragmentViewModel(): FavouritePostsFragmentViewModel =
        FavouritePostsFragmentViewModel()

    @Provides
    fun provideMainPageFragmentViewModel(carInteractor: CarInteractor): MainPageFragmentViewModel =
        MainPageFragmentViewModel(carInteractor)

    @Provides
    fun providePersonalPageFragmentViewModel(): PersonalPageFragmentViewModel =
        PersonalPageFragmentViewModel()

    @Provides
    fun provideMainActivityViewModel(): MainActivityViewModel =
        MainActivityViewModel()

    @Provides
    fun provideLoginActivityViewModel(accountsInteractor: AccountsInteractor): LoginActivityViewModel =
        LoginActivityViewModel(accountsInteractor)

    @Provides
    fun provideRegisterActivityViewModel(accountsInteractor: AccountsInteractor): RegisterActivityViewModel =
        RegisterActivityViewModel(accountsInteractor)

}