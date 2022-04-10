package com.example.cars.app.domain

import com.example.cars.app.data.room.userPosts.models.UserPostEntity

interface UserPostsDbRepository {

    suspend fun getUserPosts(): List<UserPostEntity>

    suspend fun saveUserPost(userPostEntity: UserPostEntity)

    suspend fun deleteUserPost(userPostEntity: UserPostEntity)
}