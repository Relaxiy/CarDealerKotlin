package com.example.cars.di

import com.example.cars.app.domain.FavouritePostsDbRepository
import com.example.cars.app.data.room.favouritePosts.FavouritePostsDbRepositoryImpl
import com.example.cars.app.domain.UserPostsDbRepository
import com.example.cars.app.data.room.userPosts.UserPostsDbRepositoryImpl
import com.example.cars.registration.domain.AccountsRepository
import com.example.cars.registration.data.AccountsRepositoryImpl
import com.example.cars.registration.data.firebase.FirebaseDatabaseManager
import com.example.cars.registration.data.firebase.FirebaseDatabaseManagerImpl
import dagger.Binds
import dagger.Module

@Module
interface RepositoriesModule {
    @Binds
    fun bindFavouritePostsRepository(postsRepositoryImpl: FavouritePostsDbRepositoryImpl): FavouritePostsDbRepository

    @Binds
    fun bindUserPostsRepository(userPostsRepositoryImpl: UserPostsDbRepositoryImpl): UserPostsDbRepository

}