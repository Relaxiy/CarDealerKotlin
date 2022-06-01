package com.example.cars.registration.domain.mapper

import com.example.cars.registration.data.room.models.AccountDbEntity
import com.example.cars.registration.domain.models.Account

fun AccountDbEntity.toAccount() = Account(
    username = username,
    email = email,
    birthday = birthday,
    password = password
)