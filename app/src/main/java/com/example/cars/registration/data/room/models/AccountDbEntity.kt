package com.example.cars.registration.data.room.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.cars.registration.domain.models.Account
import com.example.cars.registration.domain.models.SignUpData

@Entity(
    tableName = "accounts",
    indices = [
        Index("email", unique = true)
    ]
)
data class AccountDbEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "username")
    val username: String,
    @ColumnInfo(name = "email", collate = ColumnInfo.NOCASE)
    val email: String,
    @ColumnInfo(name = "birthday")
    val birthday: String,
    @ColumnInfo(name = "password")
    val password: String,
    @ColumnInfo(name = "created_at")
    val createdAt: Long
) {
    fun toAccount(): Account = Account(
        id = id,
        username = username,
        email = email,
        birthday = birthday,
        createdAt = createdAt
    )

    companion object {
        fun fromSignUpData(signUpData: SignUpData): AccountDbEntity = AccountDbEntity(
            id = 0,
            username = signUpData.username,
            email = signUpData.email,
            birthday = signUpData.birthday,
            password = signUpData.password,
            createdAt = System.currentTimeMillis()
        )
    }
}
