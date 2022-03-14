package com.example.cars.registration.presentation.di

import com.example.cars.registration.presentation.viewModels.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val registrationViewModelModule = module {
    viewModel {
        LoginViewModel(
            userInteractor = get()
        )
    }
}