package com.example.cars.registration.data

import com.example.cars.registration.data.firebase.FirebaseDatabaseManager
import com.example.cars.registration.data.room.dao.AccountsDao
import com.example.cars.registration.data.room.tuples.AccountUpdateUsernameTuple
import com.example.cars.registration.data.utils.toAccountEntity
import com.example.cars.registration.domain.AccountsRepository
import com.example.cars.registration.domain.models.SignInData
import com.example.cars.registration.domain.models.SignUpData
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AccountsRepositoryImpl @Inject constructor(
    private val accountsDao: AccountsDao,
    private val firebaseDatabaseManager: FirebaseDatabaseManager
) : AccountsRepository {

    override suspend fun findAccountByEmailAndPassword(signInData: SignInData): QuerySnapshot? {
        return firebaseDatabaseManager.findAccountByEmailAndPassword(signInData)
    }

    override suspend fun findAccountByEmail(phoneNumber: String): QuerySnapshot? {
        return firebaseDatabaseManager.findAccountByPhoneNumber(phoneNumber)
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

    override suspend fun changePassword(password: String, documentPath: String){
        firebaseDatabaseManager.changePassword(password, documentPath)
    }
}