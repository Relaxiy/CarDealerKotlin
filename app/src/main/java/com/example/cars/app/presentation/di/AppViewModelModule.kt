package com.example.cars.app.presentation.di

import com.example.cars.app.presentation.viewModels.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appViewModelModule = module {
    viewModel {
        AddCarFragmentViewModel(
            carInteractor = get()
        )
    }

    viewModel {
        CarModelsBottomFragmentViewModel(
            carInteractor = get()
        )
    }

    viewModel {
        CarModelsFragmentViewModel(
            carInteractor = get()
        )
    }

    viewModel {
        FavouriteCarsFragmentViewModel()
    }

    viewModel {
        MainPageFragmentViewModel(
            carInteractor = get()
        )
    }

    viewModel {
        PersonalPageFragmentViewModel()
    }

}