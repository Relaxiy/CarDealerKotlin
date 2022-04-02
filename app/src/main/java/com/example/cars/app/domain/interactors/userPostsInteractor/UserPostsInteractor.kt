package com.example.cars.app.domain.interactors.userPostsInteractor

import com.example.cars.app.domain.models.UserPost

interface UserPostsInteractor {

    suspend fun getUserPosts(): List<UserPost>

    suspend fun saveUserPost(userPost: UserPost)

    suspend fun deleteUserPost(userPost: UserPost)
}