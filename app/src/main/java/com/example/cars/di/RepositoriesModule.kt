package com.example.cars.di

import com.example.cars.app.data.room.roomFavouritePosts.repository.FavouritePostsDbRepository
import com.example.cars.app.data.room.roomFavouritePosts.repository.FavouritePostsDbRepositoryImpl
import com.example.cars.app.data.room.roomUserPosts.repository.UserPostsDbRepository
import com.example.cars.app.data.room.roomUserPosts.repository.UserPostsDbRepositoryImpl
import com.example.cars.registration.data.room.repository.AccountsRepository
import com.example.cars.registration.data.room.repository.AccountsRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface RepositoriesModule {
    @Binds
    fun bindFavouritePostsRepository(postsRepositoryImpl: FavouritePostsDbRepositoryImpl): FavouritePostsDbRepository

    @Binds
    fun bindAccountsRepository(accountsRepositoryImpl: AccountsRepositoryImpl): AccountsRepository

    @Binds
    fun bindUserPostsRepository(userPostsRepositoryImpl: UserPostsDbRepositoryImpl): UserPostsDbRepository


}