package com.example.cars.app.data.room.repository

import com.example.cars.app.data.room.models.FavouritePostEntity

interface PostsRepository {

    suspend fun getFavouritePosts(): List<FavouritePostEntity>

    suspend fun saveFavouritePost(favouritePostEntity: FavouritePostEntity)

    suspend fun deleteFavouritePost(favouritePostEntity: FavouritePostEntity)
}