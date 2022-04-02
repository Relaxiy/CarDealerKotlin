package com.example.cars.app.domain.interactors.userPostsInteractor

import com.example.cars.app.data.room.roomUserPosts.repository.UserPostsDbRepository
import com.example.cars.app.domain.models.UserPost
import javax.inject.Inject

class UserPostsInteractorImpl @Inject constructor(
    userPostsDbRepository: UserPostsDbRepository
) : UserPostsInteractor {

    override suspend fun getUserPosts(): List<UserPost> {
        TODO("Not yet implemented")
    }

    override suspend fun saveUserPost(userPost: UserPost) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteUserPost(userPost: UserPost) {
        TODO("Not yet implemented")
    }

}