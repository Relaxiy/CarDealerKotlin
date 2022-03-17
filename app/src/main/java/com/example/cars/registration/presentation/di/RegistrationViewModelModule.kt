package com.example.cars.registration.presentation.di

import com.example.cars.registration.presentation.viewModels.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val registrationViewModelModule = module {
    viewModel {
        RegisterViewModel(
            userInteractor = get()
        )
    }
}