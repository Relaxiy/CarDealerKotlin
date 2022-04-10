package com.example.cars.registration.domain.mapper

import com.example.cars.registration.data.network.models.AccountResponse
import com.example.cars.registration.data.room.models.AccountDbEntity
import com.example.cars.registration.domain.models.Account
import com.example.cars.registration.domain.models.SignUpData

fun Account.toAccountResponse() = AccountResponse(
    id = id,
    username = username,
    email = email,
    birthday = birthday,
    password = password,
    createdAt = createdAt
)

fun AccountResponse.toAccount() = Account(
    id = id,
    username = username,
    email = email,
    birthday = birthday,
    password = password,
    createdAt = createdAt
)

fun AccountDbEntity.toAccount() = Account(
    id = id,
    username = username,
    email = email,
    birthday = birthday,
    password = password,
    createdAt = createdAt
)

fun SignUpData.toAccountDbEntity() = AccountDbEntity(
    username = username,
    email = email,
    birthday = birthday,
    password = password
)