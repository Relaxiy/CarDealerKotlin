package com.example.cars.app.data.room.userPosts.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cars.app.data.room.userPosts.models.UserPostEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class UserPostEntity(
    @PrimaryKey(autoGenerate = true)
    var uid: Long = 0,
    @ColumnInfo(name = "images")
    val images: String,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "car_model")
    val carModel: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "price")
    val price: String,
    @ColumnInfo(name = "person_name")
    val personName: String,
    @ColumnInfo(name = "email")
    val email: String,
    @ColumnInfo(name = "phone_number")
    val phoneNumber: String
) {
    companion object {
        const val TABLE_NAME = "user_posts"
    }
}
