package com.example.cars.registration.data.room.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.cars.registration.data.room.models.AccountDbEntity.Companion.TABLE_NAME
import com.example.cars.utils.date.CurrentDate


@Entity(
    tableName = TABLE_NAME,
    indices = [
        Index("email", unique = true)
    ]
)
data class AccountDbEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    @ColumnInfo(name = "username")
    val username: String,
    @ColumnInfo(name = "email", collate = ColumnInfo.NOCASE)
    val email: String,
    @ColumnInfo(name = "birthday")
    val birthday: String,
    @ColumnInfo(name = "password")
    val password: String,
    @ColumnInfo(name = "created_at")
    val createdAt: String = CurrentDate.currentDate
) {
    companion object {
        const val TABLE_NAME = "accounts"
    }
}
