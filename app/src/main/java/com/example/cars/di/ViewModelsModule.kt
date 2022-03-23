package com.example.cars.di

import com.example.cars.app.domain.interactors.CarInteractor
import com.example.cars.app.presentation.viewModels.*
import com.example.cars.registration.domain.interactor.AccountsInteractor
import com.example.cars.registration.presentation.viewModels.LoginActivityViewModel
import com.example.cars.registration.presentation.viewModels.RegisterActivityViewModel
import dagger.Module
import dagger.Provides

@Module
class ViewModelsModule