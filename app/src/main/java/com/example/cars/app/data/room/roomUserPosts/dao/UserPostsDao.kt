package com.example.cars.app.data.room.roomUserPosts.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.cars.app.data.room.roomUserPosts.models.UserPostEntity

@Dao
interface UserPostsDao {
    @Query("SELECT * FROM favourite_posts")
    suspend fun getUserPosts(): List<UserPostEntity>

    @Insert
    suspend fun saveUserPost(userPostEntity: UserPostEntity)

    @Delete
    suspend fun deleteUserPost(userPostEntity: UserPostEntity)
}