package com.example.cars.registration.domain.interactor

import android.util.Log
import com.example.cars.registration.data.firebase.FirebaseDatabaseManagerImpl
import com.example.cars.registration.domain.models.Account
import com.example.cars.registration.domain.AccountsRepository
import com.example.cars.registration.domain.models.SignUpData
import com.example.cars.registration.domain.models.SignInData
import com.example.cars.registration.presentation.login.actionSelector.AccountSearchResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AccountsInteractorImpl @Inject constructor(
    private val accountsRepository: AccountsRepository
) : AccountsInteractor {

    override suspend fun findAccountIdByEmailAndPassword(signInData: SignInData): AccountSearchResult {
        return try {
            val task = accountsRepository.findAccountIdByEmailAndPassword(signInData)
            if (task != null && task.documents.size > 0) {
                val documentSnapshot = task.documents[0]
                AccountSearchResult.SuccessResult(
                    Account(
                        username = documentSnapshot.get(FirebaseDatabaseManagerImpl.KEY_USERNAME)
                            .toString(),
                        email = documentSnapshot.get(FirebaseDatabaseManagerImpl.KEY_BIRTHDAY)
                            .toString(),
                        password = documentSnapshot.get(FirebaseDatabaseManagerImpl.KEY_PASSWORD)
                            .toString(),
                        birthday = documentSnapshot.get(FirebaseDatabaseManagerImpl.KEY_BIRTHDAY)
                            .toString()
                    )
                )
            } else {
                AccountSearchResult.WrongResult()
            }
        } catch (e: Exception){
            return AccountSearchResult.WrongResult()
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