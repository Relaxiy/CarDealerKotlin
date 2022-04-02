package com.example.cars.app.domain.interactors.userPostsInteractor

import com.example.cars.app.data.room.userPosts.repository.UserPostsDbRepository
import com.example.cars.app.domain.mappers.toDeletedUserPostEntity
import com.example.cars.app.domain.mappers.toSavedUserPostEntity
import com.example.cars.app.domain.mappers.toUserPost
import com.example.cars.app.domain.models.UserPost
import javax.inject.Inject

class UserPostsInteractorImpl @Inject constructor(
    private val userPostsDbRepository: UserPostsDbRepository
) : UserPostsInteractor {

    override suspend fun getUserPosts(): List<UserPost> {
        return userPostsDbRepository.getUserPosts().map { userPostEntity ->
            userPostEntity.toUserPost()
        }
    }

    override suspend fun saveUserPost(userPost: UserPost) {
        userPostsDbRepository.saveUserPost(
            userPostEntity = userPost.toSavedUserPostEntity()
        )
    }

    override suspend fun deleteUserPost(userPost: UserPost) {
        userPostsDbRepository.deleteUserPost(
            userPostEntity = userPost.toDeletedUserPostEntity()
        )
    }

}