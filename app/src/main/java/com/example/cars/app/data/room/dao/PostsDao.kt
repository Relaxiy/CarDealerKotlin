package com.example.cars.app.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.cars.app.data.room.models.FavouritePostEntity
import retrofit2.http.DELETE

@Dao
interface PostsDao {
    @Query("SELECT * FROM favourite_posts")
    suspend fun getFavouritePosts(): List<FavouritePostEntity>

    @Insert
    suspend fun saveFavouritePost(favouritePostEntity: FavouritePostEntity)

    @DELETE
    suspend fun deleteFavouritePost(favouritePostEntity: FavouritePostEntity)
}