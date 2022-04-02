package com.example.cars.app.data.room.roomFavouritePosts.repository

import com.example.cars.app.data.room.roomFavouritePosts.models.FavouritePostEntity

interface FavouritePostsDbRepository {

    suspend fun getFavouritePosts(): List<FavouritePostEntity>

    suspend fun saveFavouritePost(favouritePostEntity: FavouritePostEntity)

    suspend fun deleteFavouritePost(favouritePostEntity: FavouritePostEntity)
}