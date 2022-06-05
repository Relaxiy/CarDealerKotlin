package com.example.cars.registration.domain

import com.example.cars.registration.domain.models.SignInData
import com.example.cars.registration.domain.models.SignUpData
import com.google.firebase.firestore.QuerySnapshot

interface AccountsRepository {

    suspend fun findAccountIdByEmailAndPassword(signInData: SignInData): QuerySnapshot?

    suspend fun createAccount(signUpData: SignUpData)

    suspend fun updateUsernameForAccountId(accountId: Long, newUsername: String)

}