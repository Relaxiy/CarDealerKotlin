package com.example.cars.app.data.room.roomUserPosts.repository

import com.example.cars.app.data.room.roomUserPosts.dao.UserPostsDao
import com.example.cars.app.data.room.roomUserPosts.models.UserPostEntity
import javax.inject.Inject

class UserPostsDbRepositoryImpl @Inject constructor(
    userPostsDao: UserPostsDao
) : UserPostsDbRepository {

    override suspend fun getUserPosts(): List<UserPostEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun saveUserPost(userPostEntity: UserPostEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteUserPost(userPostEntity: UserPostEntity) {
        TODO("Not yet implemented")
    }

}