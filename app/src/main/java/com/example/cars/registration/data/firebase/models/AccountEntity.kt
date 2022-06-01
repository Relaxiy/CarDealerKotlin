package com.example.cars.registration.data.firebase.models

import androidx.room.ColumnInfo
import com.example.cars.utils.date.CurrentDate

data class AccountEntity(
    val username: String,
    val email: String,
    val birthday: String,
    val password: String,
    val createdAt: String = CurrentDate.currentDate
)