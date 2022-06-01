package com.example.cars.registration.data.firebase

import android.util.Log
import com.example.cars.registration.data.firebase.models.AccountEntity
import com.example.cars.registration.data.utils.await
import com.example.cars.registration.domain.models.Account
import com.example.cars.registration.domain.models.SignInData
import com.example.cars.registration.domain.models.SignUpData
import com.example.cars.registration.presentation.login.actionSelector.AccountSearchResult
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FirebaseDatabaseManagerImpl @Inject constructor() : FirebaseDatabaseManager {
    companion object {
        const val KEY_COLLECTION_USERS = "users"
        const val KEY_EMAIL = "email"
        const val KEY_PASSWORD = "password"
        const val KEY_BIRTHDAY = "birthday"
        const val KEY_USERNAME = "username"
        const val KEY_ID = "id"
    }

    override suspend fun createAccount(accountEntity: AccountEntity) {
        FirebaseFirestore.getInstance().collection(KEY_COLLECTION_USERS).add(accountEntity)
    }

    override suspend fun findAccountIdByEmailAndPassword(signInData: SignInData): QuerySnapshot? =
        withContext(Dispatchers.IO) {
            return@withContext FirebaseFirestore.getInstance().collection(KEY_COLLECTION_USERS)
                .whereEqualTo(KEY_EMAIL, signInData.email)
                .whereEqualTo(KEY_PASSWORD, signInData.password)
                .get()
                .await()
        }
}