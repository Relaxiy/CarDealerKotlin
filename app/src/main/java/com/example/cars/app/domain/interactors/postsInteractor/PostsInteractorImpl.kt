package com.example.cars.app.domain.interactors.postsInteractor

import com.example.cars.app.data.room.repository.PostsRepository
import com.example.cars.app.domain.mapper.toDeletedFavouritePostEntity
import com.example.cars.app.domain.mapper.toFavouritePost
import com.example.cars.app.domain.mapper.toSavedFavouritePostEntity
import com.example.cars.app.domain.models.FavouritePost
import javax.inject.Inject

class PostsInteractorImpl @Inject constructor(
    private val postsRepository: PostsRepository
) : PostsInteractor {
    override suspend fun getFavouritePosts(): List<FavouritePost> {
        return postsRepository.getFavouritePosts().map { favouritePostEntity ->
            favouritePostEntity.toFavouritePost()
        }
    }

    override suspend fun saveFavouritePost(favouritePost: FavouritePost) {
        postsRepository.saveFavouritePost(favouritePostEntity = favouritePost.toSavedFavouritePostEntity())
    }

    override suspend fun deleteFavouritePost(favouritePost: FavouritePost) {
        postsRepository.deleteFavouritePost(favouritePostEntity = favouritePost.toDeletedFavouritePostEntity())
    }
}