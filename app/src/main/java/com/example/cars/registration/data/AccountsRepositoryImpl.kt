package com.example.cars.registration.data

import com.example.cars.registration.data.room.dao.AccountsDao
import com.example.cars.registration.data.room.tuples.AccountUpdateUsernameTuple
import com.example.cars.registration.domain.AccountsRepository
import com.example.cars.registration.domain.mapper.fromSignUpData
import com.example.cars.registration.domain.mapper.toAccount
import com.example.cars.registration.domain.models.Account
import com.example.cars.registration.domain.models.SignInData
import com.example.cars.registration.domain.models.SignUpData
import com.example.cars.registration.presentation.login.actionSelector.AccountSearchResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AccountsRepositoryImpl @Inject constructor(
    private val accountsDao: AccountsDao
) : AccountsRepository {

    override suspend fun findAccountIdByEmailAndPassword(signInData: SignInData): AccountSearchResult {
        return withContext(Dispatchers.IO) {
            val tuple = accountsDao.findByEmail(signInData.email)
            return@withContext when {
                tuple == null -> AccountSearchResult.WrongEmailResult()
                tuple.password != signInData.password -> AccountSearchResult.WrongPasswordResult()
                else -> AccountSearchResult.SuccessResult(tuple.id)
            }
        }
    }

    override suspend fun createAccount(signUpData: SignUpData) {
        withContext(Dispatchers.IO) {
            val entity = signUpData.fromSignUpData()
            accountsDao.createAccount(entity)
        }
    }

    override suspend fun getAccountById(accountId: Long): Flow<Account?> = flow {
        accountsDao.getAccountById(accountId).map { accountDbEntity ->
            accountDbEntity?.toAccount()
        }.flowOn(Dispatchers.IO)
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