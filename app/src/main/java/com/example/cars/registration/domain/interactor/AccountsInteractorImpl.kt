package com.example.cars.registration.domain.interactor

import android.accounts.AuthenticatorException
import android.database.sqlite.SQLiteConstraintException
import com.example.cars.registration.data.room.dao.AccountsDao
import com.example.cars.registration.domain.models.Account
import com.example.cars.registration.data.room.models.AccountDbEntity
import com.example.cars.registration.domain.models.SignUpData
import com.example.cars.registration.data.room.tuples.AccountUpdateUsernameTuple
import com.example.cars.registration.domain.models.AccountSignIn
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

class AccountsInteractorImpl @Inject constructor(private val accountsDao: AccountsDao) : AccountsInteractor {

    override suspend fun findAccountIdByEmailAndPassword(accountSignIn: AccountSignIn): Long {
        val tuple = accountsDao.findByEmail(accountSignIn.email) ?: throw AuthenticatorException()
        if (tuple.password != accountSignIn.password) throw AuthenticatorException()
        return tuple.id
    }

    override suspend fun createAccount(signUpData: SignUpData) {
        try {
            val entity = AccountDbEntity.fromSignUpData(signUpData)
            accountsDao.createAccount(entity)
        } catch (e: SQLiteConstraintException) {
        }
    }

    override suspend fun getAccountById(accountId: Long): Flow<Account?> {
        return accountsDao.getAccountById(accountId).map { accountDbEntity ->
            accountDbEntity?.toAccount()
        }
    }

    override suspend fun updateUsernameForAccountId(accountId: Long, newUsername: String) {
        accountsDao.updateUsername(
            AccountUpdateUsernameTuple(
                accountId,
                newUsername
            )
        )
    }


}