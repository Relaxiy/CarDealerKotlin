package com.example.cars.app.domain.interactors.userPostsInteractor

import com.example.cars.app.domain.UserPostsRepository
import com.example.cars.app.domain.mappers.toUserPostEntity
import com.example.cars.app.domain.mappers.toUserPostResponse
import com.example.cars.app.domain.models.UserPost
import com.example.cars.app.domain.models.UserPostResponse
import javax.inject.Inject

class UserPostsInteractorImpl @Inject constructor(
    private val userPostsRepository: UserPostsRepository
) : UserPostsInteractor {

    override suspend fun getUserPosts(): List<UserPostResponse> {
        return userPostsRepository.getUserPosts().map { userPostEntity ->
            userPostEntity.toUserPostResponse()
        }
    }

    override suspend fun getUserPostsFromFirebase(documentPath: String): List<UserPostResponse> {
        val documentsList = userPostsRepository.getUserPostsFromFirebase(documentPath)?.documents
        if (documentsList != null)
    }

    override suspend fun saveUserPostInRoom(userPostResponse: UserPostResponse) {
        userPostsRepository.saveUserPost(
            userPostEntity = userPostResponse.toUserPostEntity()
        )
    }

    override suspend fun deleteUserPostInRoom(userPostResponse: UserPostResponse) {
        userPostsRepository.deleteUserPost(userPostResponse.toUserPostEntity())
    }

    override suspend fun saveUserPostInFirestore(userPost: UserPost) : UserPostResponse {
       return UserPostResponse(
           id = userPostsRepository.saveUserPostInFirestore(userPost),
           userId = userPost.userId,
           images = userPost.images,
           title = userPost.title,
           description = userPost.description,
           price = userPost.price,
           personName = userPost.personName,
           email = userPost.email,
           phoneNumber = userPost.phoneNumber,
           date = userPost.date
       )
    }

    override suspend fun deleteUserPostInFirestore(userPostResponse: UserPostResponse) {
        userPostsRepository.deleteUserPostInFirestore(userPostResponse)
    }


}