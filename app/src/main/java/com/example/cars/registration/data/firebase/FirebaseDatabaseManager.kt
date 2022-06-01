package com.example.cars.registration.data.firebase

import com.example.cars.registration.data.firebase.models.AccountEntity
import com.example.cars.registration.data.network.models.AccountResponse
import com.example.cars.registration.domain.models.Account
import com.example.cars.registration.domain.models.SignInData
import com.example.cars.registration.domain.models.SignUpData
import com.example.cars.registration.presentation.login.actionSelector.AccountSearchResult
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.coroutines.flow.Flow

interface FirebaseDatabaseManager {

    suspend fun createAccount(accountEntity: AccountEntity)

    suspend fun findAccountIdByEmailAndPassword(signInData: SignInData): QuerySnapshot?
}