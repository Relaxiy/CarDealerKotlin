package com.example.cars.registration.domain

import com.example.cars.registration.domain.models.Account
import com.example.cars.registration.domain.models.SignInData
import com.example.cars.registration.domain.models.SignUpData
import com.example.cars.registration.presentation.login.actionSelector.AccountSearchResult
import kotlinx.coroutines.flow.Flow

interface AccountsRepository {

    suspend fun findAccountIdByEmailAndPassword(signInData: SignInData): AccountSearchResult

    suspend fun createAccount(signUpData: SignUpData)

    suspend fun getAccountById(accountId: Long): Flow<Account?>

    suspend fun updateUsernameForAccountId(accountId: Long, newUsername: String)
}