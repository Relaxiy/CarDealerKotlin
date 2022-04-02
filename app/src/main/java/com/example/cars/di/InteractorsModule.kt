package com.example.cars.di

import com.example.cars.app.domain.interactors.carInteractor.CarInteractor
import com.example.cars.app.domain.interactors.carInteractor.CarInteractorImpl
import com.example.cars.app.domain.interactors.postsInteractor.PostsDbInteractor
import com.example.cars.app.domain.interactors.postsInteractor.PostsDbInteractorImpl
import com.example.cars.registration.domain.interactor.AccountsInteractor
import com.example.cars.registration.domain.interactor.AccountsInteractorImpl
import dagger.Binds
import dagger.Module

@Module
interface InteractorsModule {

    @Binds
    fun bindAccountInteractor(accountsInteractorImpl: AccountsInteractorImpl): AccountsInteractor

    @Binds
    fun bindCarInteractor(carInteractorImpl: CarInteractorImpl): CarInteractor

    @Binds
    fun bindPostsInteractor(postsInteractorImpl: PostsDbInteractorImpl): PostsDbInteractor
}