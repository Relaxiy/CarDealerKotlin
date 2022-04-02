package com.example.cars.app.domain.interactors.favouritePostsInteractor

import com.example.cars.app.data.room.roomFavouritePosts.repository.FavouritePostsDbRepository
import com.example.cars.app.domain.mapper.toDeletedFavouritePostEntity
import com.example.cars.app.domain.mapper.toFavouritePost
import com.example.cars.app.domain.mapper.toSavedFavouritePostEntity
import com.example.cars.app.domain.models.FavouritePost
import javax.inject.Inject

class FavouritePostsInteractorImpl @Inject constructor(
    private val favouritePostsDbRepository: FavouritePostsDbRepository
) : FavouritePostsInteractor {
    override suspend fun getFavouritePosts(): List<FavouritePost> {
        return favouritePostsDbRepository.getFavouritePosts().map { favouritePostEntity ->
            favouritePostEntity.toFavouritePost()
        }
    }

    override suspend fun saveFavouritePost(favouritePost: FavouritePost) {
        favouritePostsDbRepository.saveFavouritePost(favouritePostEntity = favouritePost.toSavedFavouritePostEntity())
    }

    override suspend fun deleteFavouritePost(favouritePost: FavouritePost) {
        favouritePostsDbRepository.deleteFavouritePost(favouritePostEntity = favouritePost.toDeletedFavouritePostEntity())
    }
}