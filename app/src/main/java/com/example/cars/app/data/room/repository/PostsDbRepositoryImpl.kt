package com.example.cars.app.data.room.repository

import com.example.cars.app.data.room.dao.FavouritePostsDao
import com.example.cars.app.data.room.models.FavouritePostEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PostsDbRepositoryImpl @Inject constructor(
    private val postsDao: FavouritePostsDao
) : PostsDbRepository {

    override suspend fun getFavouritePosts(): List<FavouritePostEntity> {
        return withContext(Dispatchers.IO){
            return@withContext postsDao.getFavouritePosts()
        }
    }

    override suspend fun saveFavouritePost(favouritePostEntity: FavouritePostEntity) {
       withContext(Dispatchers.IO){
           postsDao.saveFavouritePost(favouritePostEntity)
       }
    }

    override suspend fun deleteFavouritePost(favouritePostEntity: FavouritePostEntity) {
        withContext(Dispatchers.IO){
            postsDao.deleteFavouritePost(favouritePostEntity)
        }
    }
}