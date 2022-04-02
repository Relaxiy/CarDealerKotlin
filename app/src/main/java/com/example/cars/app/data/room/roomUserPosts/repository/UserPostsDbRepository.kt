package com.example.cars.app.data.room.roomUserPosts.repository

import com.example.cars.app.data.room.roomUserPosts.models.UserPostEntity

interface UserPostsDbRepository {

    suspend fun getUserPosts(): List<UserPostEntity>

    suspend fun saveUserPost(userPostEntity: UserPostEntity)

    suspend fun deleteUserPost(userPostEntity: UserPostEntity)
}