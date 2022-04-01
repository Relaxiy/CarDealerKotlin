package com.example.cars.app.domain.interactors.postsInteractor

import com.example.cars.app.data.room.repository.PostsRepository
import com.example.cars.app.domain.models.FavouritePost
import javax.inject.Inject

class PostsInteractorImpl @Inject constructor(
    private val postsRepository: PostsRepository
) : PostsInteractor {
    override suspend fun getFavouritePosts(): List<FavouritePost> {
        TODO("Not yet implemented")
    }

    override suspend fun saveFavouritePost(favouritePost: FavouritePost) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteFavouritePost(favouritePost: FavouritePost) {
        TODO("Not yet implemented")
    }
}