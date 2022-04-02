package com.example.cars.app.domain.interactors.postsInteractor

import com.example.cars.app.data.room.repository.PostsDbRepository
import com.example.cars.app.domain.mapper.toDeletedFavouritePostEntity
import com.example.cars.app.domain.mapper.toFavouritePost
import com.example.cars.app.domain.mapper.toSavedFavouritePostEntity
import com.example.cars.app.domain.models.FavouritePost
import javax.inject.Inject

class PostsDbInteractorImpl @Inject constructor(
    private val postsDbRepository: PostsDbRepository
) : PostsDbInteractor {
    override suspend fun getFavouritePosts(): List<FavouritePost> {
        return postsDbRepository.getFavouritePosts().map { favouritePostEntity ->
            favouritePostEntity.toFavouritePost()
        }
    }

    override suspend fun saveFavouritePost(favouritePost: FavouritePost) {
        postsDbRepository.saveFavouritePost(favouritePostEntity = favouritePost.toSavedFavouritePostEntity())
    }

    override suspend fun deleteFavouritePost(favouritePost: FavouritePost) {
        postsDbRepository.deleteFavouritePost(favouritePostEntity = favouritePost.toDeletedFavouritePostEntity())
    }
}