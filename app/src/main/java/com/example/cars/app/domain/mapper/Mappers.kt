package com.example.cars.app.domain.mapper

import com.example.cars.app.data.room.models.FavouritePostEntity
import com.example.cars.app.domain.models.FavouritePost

fun FavouritePost.toSavedFavouritePostEntity() = FavouritePostEntity(
    images = images,
    title = title,
    carModel = carModel,
    description = description,
    price = price,
    personName = personName,
    email = email,
    phoneNumber = phoneNumber
)

fun FavouritePost.toDeletedFavouritePostEntity() = FavouritePostEntity(
    uid = uid,
    images = images,
    title = title,
    carModel = carModel,
    description = description,
    price = price,
    personName = personName,
    email = email,
    phoneNumber = phoneNumber
)

fun FavouritePostEntity.toFavouritePost() = FavouritePost(
    uid = uid,
    images = images,
    title = title,
    carModel = carModel,
    description = description,
    price = price,
    personName = personName,
    email = email,
    phoneNumber = phoneNumber
)