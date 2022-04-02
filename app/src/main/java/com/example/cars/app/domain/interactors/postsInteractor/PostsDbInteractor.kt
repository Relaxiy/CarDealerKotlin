package com.example.cars.app.domain.interactors.postsInteractor

import com.example.cars.app.domain.models.FavouritePost

interface PostsDbInteractor {

    suspend fun getFavouritePosts(): List<FavouritePost>

    suspend fun saveFavouritePost(favouritePost: FavouritePost)

    suspend fun deleteFavouritePost(favouritePost: FavouritePost)
}