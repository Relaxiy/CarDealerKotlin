package com.example.cars.app.domain.interactors.favouritePostsInteractor

import com.example.cars.app.domain.models.FavouritePost

interface FavouritePostsInteractor {

    suspend fun getFavouritePosts(): List<FavouritePost>

    suspend fun saveFavouritePost(favouritePost: FavouritePost)

    suspend fun deleteFavouritePost(favouritePost: FavouritePost)
}