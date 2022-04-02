package com.example.cars.app.domain.interactors.favouritePostsInteractor

import com.example.cars.app.data.room.favouritePosts.repository.FavouritePostsDbRepository
import com.example.cars.app.domain.mappers.toDeletedFavouritePostEntity
import com.example.cars.app.domain.mappers.toFavouritePost
import com.example.cars.app.domain.mappers.toSavedFavouritePostEntity
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
        favouritePostsDbRepository.saveFavouritePost(
            favouritePostEntity = favouritePost.toSavedFavouritePostEntity()
        )
    }

    override suspend fun deleteFavouritePost(favouritePost: FavouritePost) {
        favouritePostsDbRepository.deleteFavouritePost(
            favouritePostEntity = favouritePost.toDeletedFavouritePostEntity()
        )
    }
}