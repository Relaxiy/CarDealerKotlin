package com.example.cars.app.data.room.userPosts

import com.example.cars.app.data.room.userPosts.dao.UserPostsDao
import com.example.cars.app.data.room.userPosts.models.UserPostEntity
import com.example.cars.app.domain.UserPostsDbRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserPostsDbRepositoryImpl @Inject constructor(
    private val userPostsDao: UserPostsDao
) : UserPostsDbRepository {

    override suspend fun getUserPosts(): List<UserPostEntity> {
        return withContext(Dispatchers.IO) {
            return@withContext userPostsDao.getUserPosts()
        }
    }

    override suspend fun saveUserPost(userPostEntity: UserPostEntity) {
        withContext(Dispatchers.IO){
            userPostsDao.saveUserPost(userPostEntity)
        }
    }

    override suspend fun deleteUserPost(userPostEntity: UserPostEntity) {
        withContext(Dispatchers.IO){
            userPostsDao.deleteUserPost(userPostEntity)
        }
    }

}