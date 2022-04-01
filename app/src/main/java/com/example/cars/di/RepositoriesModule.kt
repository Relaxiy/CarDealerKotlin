package com.example.cars.di

import com.example.cars.app.data.room.repository.PostsRepository
import com.example.cars.app.data.room.repository.PostsRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface RepositoriesModule {
    @Binds
    fun bindPostsRepository(postsRepositoryImpl: PostsRepositoryImpl): PostsRepository
}