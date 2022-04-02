package com.example.cars.app.domain.mappers

import com.example.cars.app.data.network.models.PostResponse
import com.example.cars.app.domain.models.FavouritePost
import com.example.cars.app.domain.models.Post

fun Post.toFavouritePost() = FavouritePost(
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

fun PostResponse.toPost() = Post(
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