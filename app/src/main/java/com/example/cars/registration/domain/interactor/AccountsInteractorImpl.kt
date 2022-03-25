package com.example.cars.registration.domain.interactor

import android.accounts.AuthenticatorException
import android.database.sqlite.SQLiteConstraintException
import com.example.cars.registration.data.room.dao.AccountsDao
import com.example.cars.registration.domain.models.Account
import com.example.cars.registration.data.room.models.AccountDbEntity
import com.example.cars.registration.domain.models.SignUpData
import com.example.cars.registration.data.room.tuples.AccountUpdateUsernameTuple
import com.example.cars.registration.domain.models.SignInData
import com.example.cars.utils.exceptions.WrongEmailException
import com.example.cars.utils.exceptions.WrongPasswordException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AccountsInteractorImpl @Inject constructor(private val accountsDao: AccountsDao) :
    AccountsInteractor {

    override suspend fun findAccountIdByEmailAndPassword(signInData: SignInData): Long {
        return withContext(Dispatchers.IO) {
            val tuple =
                accountsDao.findByEmail(signInData.email) ?: throw WrongEmailException()
            if (tuple.password != signInData.password) throw WrongPasswordException()
            return@withContext tuple.id
        }
    }

    override suspend fun createAccount(signUpData: SignUpData) {
        withContext(Dispatchers.IO) {
            val entity = AccountDbEntity.fromSignUpData(signUpData)
            accountsDao.createAccount(entity)
        }
    }

    override suspend fun getAccountById(accountId: Long): Flow<Account?> {
        return withContext(Dispatchers.IO) {
            return@withContext accountsDao.getAccountById(accountId).map { accountDbEntity ->
                accountDbEntity?.toAccount()
            }
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