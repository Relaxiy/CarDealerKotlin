package com.example.cars.app.data.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.cars.app.data.room.models.FavouritePostEntity

@Dao
interface FavouritePostsDao {
    @Query("SELECT * FROM favourite_posts")
    suspend fun getFavouritePosts(): List<FavouritePostEntity>

    @Insert
    suspend fun saveFavouritePost(favouritePostEntity: FavouritePostEntity)

    @Delete
    suspend fun deleteFavouritePost(favouritePostEntity: FavouritePostEntity)
}