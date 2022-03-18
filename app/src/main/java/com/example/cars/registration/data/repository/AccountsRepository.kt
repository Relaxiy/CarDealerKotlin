package com.example.cars.registration.data.repository

import com.example.cars.registration.data.accounts.room.models.Account
import com.example.cars.registration.data.accounts.room.models.SignUpData
import kotlinx.coroutines.flow.Flow

interface AccountsRepository {

    suspend fun findAccountIdByEmailAndPassword(email: String, password: String): Long

    suspend fun createAccount(signUpData: SignUpData)

    suspend fun getAccountById(accountId: Long): Flow<Account?>

    suspend fun updateUsernameForAccountId(accountId: Long, newUsername: String)
}