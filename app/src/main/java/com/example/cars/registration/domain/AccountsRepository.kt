package com.example.cars.registration.domain

import com.example.cars.registration.data.network.models.AccountResponse
import com.example.cars.registration.domain.models.Account
import com.example.cars.registration.domain.models.SignInData
import com.example.cars.registration.domain.models.SignUpData
import com.example.cars.registration.presentation.login.actionSelector.AccountSearchResult
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.coroutines.flow.Flow

interface AccountsRepository {

    suspend fun findAccountIdByEmailAndPassword(signInData: SignInData): QuerySnapshot?

    suspend fun createAccount(signUpData: SignUpData)

    suspend fun getAccountById(accountId: Long): Flow<Account?>

    suspend fun updateUsernameForAccountId(accountId: Long, newUsername: String)

}