package com.example.cars.registration.domain.mapper

import com.example.cars.registration.data.room.models.AccountDbEntity
import com.example.cars.registration.domain.models.Account
import com.example.cars.registration.domain.models.SignUpData

fun AccountDbEntity.toAccount() = Account(
    id = id,
    username = username,
    email = email,
    birthday = birthday,
    createdAt = createdAt
)

fun SignUpData.fromSignUpData() = AccountDbEntity(
    id = 0,
    username = username,
    email = email,
    birthday = birthday,
    password = password,
    createdAt = System.currentTimeMillis()
)