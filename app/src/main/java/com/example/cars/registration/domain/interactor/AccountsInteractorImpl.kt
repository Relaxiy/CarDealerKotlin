package com.example.cars.registration.domain.interactor

import android.accounts.AuthenticatorException
import android.database.sqlite.SQLiteConstraintException
import com.example.cars.registration.data.accounts.room.dao.AccountsDao
import com.example.cars.registration.domain.models.Account
import com.example.cars.registration.data.accounts.room.models.AccountDbEntity
import com.example.cars.registration.domain.models.SignUpData
import com.example.cars.registration.data.accounts.room.tuples.AccountUpdateUsernameTuple
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AccountsInteractorImpl(private val accountsDao: AccountsDao) : AccountsInteractor {
    override suspend fun findAccountIdByEmailAndPassword(email: String, password: String): Long {
        val tuple = accountsDao.findByEmail(email) ?: throw AuthenticatorException()
        if (tuple.password != password) throw AuthenticatorException()
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