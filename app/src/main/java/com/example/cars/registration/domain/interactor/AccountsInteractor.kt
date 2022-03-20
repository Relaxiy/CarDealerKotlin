package com.example.cars.registration.domain.interactor

import com.example.cars.registration.domain.models.Account
import com.example.cars.registration.domain.models.SignUpData
import kotlinx.coroutines.flow.Flow

interface AccountsInteractor {

    suspend fun findAccountIdByEmailAndPassword(email: String, password: String): Long

    suspend fun createAccount(signUpData: SignUpData)

    suspend fun getAccountById(accountId: Long): Flow<Account?>

    suspend fun updateUsernameForAccountId(accountId: Long, newUsername: String)
}