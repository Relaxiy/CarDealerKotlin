package com.example.cars.registration.data

import com.example.cars.registration.data.firebase.FirebaseDatabaseManager
import com.example.cars.registration.data.network.api.AccountApi
import com.example.cars.registration.data.network.models.AccountResponse
import com.example.cars.registration.data.room.dao.AccountsDao
import com.example.cars.registration.data.room.tuples.AccountUpdateUsernameTuple
import com.example.cars.registration.data.utils.toAccountEntity
import com.example.cars.registration.domain.AccountsRepository
import com.example.cars.registration.domain.mapper.toAccount
import com.example.cars.registration.domain.models.Account
import com.example.cars.registration.domain.models.SignInData
import com.example.cars.registration.domain.models.SignUpData
import com.example.cars.registration.presentation.login.actionSelector.AccountSearchResult
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AccountsRepositoryImpl @Inject constructor(
    private val accountsDao: AccountsDao,
    private val firebaseDatabaseManager: FirebaseDatabaseManager
) : AccountsRepository {

    override suspend fun findAccountIdByEmailAndPassword(signInData: SignInData): QuerySnapshot? {
        return firebaseDatabaseManager.findAccountIdByEmailAndPassword(signInData)
    }

    override suspend fun createAccount(signUpData: SignUpData) {
        withContext(Dispatchers.IO) {
            firebaseDatabaseManager.createAccount(signUpData.toAccountEntity())
        }
    }

    override suspend fun updateUsernameForAccountId(accountId: Long, newUsername: String) {
        withContext(Dispatchers.IO) {
            accountsDao.updateUsername(
                AccountUpdateUsernameTuple(
                    accountId,
                    newUsername
                )
            )
        }
    }
}