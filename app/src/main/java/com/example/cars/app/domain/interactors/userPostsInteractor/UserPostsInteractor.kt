package com.example.cars.app.domain.interactors.userPostsInteractor

import com.example.cars.app.domain.models.UserPost
import com.example.cars.app.domain.models.UserPostResponse
import com.example.cars.app.presentation.addPost.actionSelector.CreateUserPostResult

interface UserPostsInteractor {

    suspend fun getUserPosts(): List<UserPostResponse>
    suspend fun getUserPostsFromFirebase(documentPath: String): List<UserPostResponse>

    suspend fun saveUserPostInRoom(userPostResponse: UserPostResponse)

    suspend fun deleteUserPostInRoom(userPostResponse: UserPostResponse)

    suspend fun saveUserPostInFirestore(userPost: UserPost): UserPostResponse

    suspend fun deleteUserPostInFirestore(userPostResponse: UserPostResponse)
}