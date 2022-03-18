package com.example.cars.registration.data.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.cars.registration.data.room.tuples.AccountSignInTuple
import com.example.cars.registration.data.room.tuples.AccountUpdateUsernameTuple

@Dao
interface AccountsDao {

    @Query("SELECT id, password FROM accounts WHERE email = :email")
    suspend fun findByEmail(email: String): AccountSignInTuple?

    suspend fun updateUsername(accountUpdateUsernameTuple: AccountUpdateUsernameTuple)
}