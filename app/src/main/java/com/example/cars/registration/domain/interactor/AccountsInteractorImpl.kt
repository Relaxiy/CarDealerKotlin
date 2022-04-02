package com.example.cars.registration.domain.interactor

import com.example.cars.registration.data.room.dao.AccountsDao
import com.example.cars.registration.domain.models.Account
import com.example.cars.registration.data.room.models.AccountDbEntity
import com.example.cars.registration.data.room.repository.AccountsRepository
import com.example.cars.registration.domain.models.SignUpData
import com.example.cars.registration.data.room.tuples.AccountUpdateUsernameTuple
import com.example.cars.registration.domain.ext.fromSignUpData
import com.example.cars.registration.domain.ext.toAccount
import com.example.cars.registration.domain.models.SignInData
import com.example.cars.utils.exceptions.AccountSearchResult
import com.example.cars.utils.exceptions.AccountSearchResult.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AccountsInteractorImpl @Inject constructor(
    private val accountsRepository: AccountsRepository
) : AccountsInteractor {

    override suspend fun findAccountIdByEmailAndPassword(signInData: SignInData): AccountSearchResult {
        return withContext(Dispatchers.IO) {
            accountsRepository.findAccountIdByEmailAndPassword(signInData)
        }
    }

    override suspend fun createAccount(signUpData: SignUpData) {
        accountsRepository.createAccount(signUpData)
    }

    override suspend fun getAccountById(accountId: Long): Flow<Account?> {
        return accountsRepository.getAccountById(accountId)
    }

    override suspend fun updateUsernameForAccountId(accountId: Long, newUsername: String) {
        accountsRepository.updateUsernameForAccountId(accountId, newUsername)
    }


}