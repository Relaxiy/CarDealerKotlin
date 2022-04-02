package com.example.cars.app.domain.mappers

import com.example.cars.app.data.room.userPosts.models.UserPostEntity
import com.example.cars.app.domain.models.UserPost

fun UserPost.toSavedUserPostEntity() = UserPostEntity(
    images = images,
    title = title,
    carModel = carModel,
    description = description,
    price = price,
    personName = personName,
    email = email,
    phoneNumber = phoneNumber
)

fun UserPost.toDeletedUserPostEntity() = UserPostEntity(
    uid = uid,
    images = images,
    title = title,
    carModel = carModel,
    description = description,
    price = price,
    personName = personName,
    email = email,
    phoneNumber = phoneNumber,
    date = date
)

fun UserPostEntity.toUserPost() = UserPost(
    uid = uid,
    images = images,
    title = title,
    carModel = carModel,
    description = description,
    price = price,
    personName = personName,
    email = email,
    phoneNumber = phoneNumber,
    date = date
)