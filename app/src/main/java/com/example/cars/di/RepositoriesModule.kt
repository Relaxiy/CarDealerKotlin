package com.example.cars.di

import com.example.cars.app.data.room.repository.PostsRepository
import com.example.cars.app.data.room.repository.PostsRepositoryImpl
import com.example.cars.registration.data.room.repository.AccountsRepository
import com.example.cars.registration.data.room.repository.AccountsRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface RepositoriesModule {
    @Binds
    fun bindPostsRepository(postsRepositoryImpl: PostsRepositoryImpl): PostsRepository

    @Binds
    fun bindAccountsRepository(accountsRepositoryImpl: AccountsRepositoryImpl): AccountsRepository
}