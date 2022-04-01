package com.example.cars.app.data.room.repository

import com.example.cars.app.data.room.dao.PostsDao
import com.example.cars.app.data.room.models.FavouritePostEntity
import javax.inject.Inject

class PostsRepositoryImpl @Inject constructor(
    private val postsDao: PostsDao
) : PostsRepository {
    override suspend fun getFavouritePosts(): List<FavouritePostEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun saveFavouritePost(favouritePostEntity: FavouritePostEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteFavouritePost(favouritePostEntity: FavouritePostEntity) {
        TODO("Not yet implemented")
    }
}