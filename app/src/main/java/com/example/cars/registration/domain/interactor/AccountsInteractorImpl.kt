package com.example.cars.registration.domain.interactor

import com.example.cars.registration.data.firebase.FirebaseDatabaseManagerImpl
import com.example.cars.registration.domain.models.Account
import com.example.cars.registration.domain.AccountsRepository
import com.example.cars.registration.domain.models.SignUpData
import com.example.cars.registration.domain.models.SignInData
import com.example.cars.registration.presentation.login.actionSelector.AccountSearchResult
import javax.inject.Inject

class AccountsInteractorImpl @Inject constructor(
    private val accountsRepository: AccountsRepository
) : AccountsInteractor {

    override suspend fun findAccountIdByEmailAndPassword(signInData: SignInData): AccountSearchResult {
        return try {
            val task = accountsRepository.findAccountByEmailAndPassword(signInData)
            if (task != null && task.documents.size > 0) {
                val documentSnapshot = task.documents[0]
                AccountSearchResult.SuccessResult(
                    Account(
                        username = documentSnapshot.get(FirebaseDatabaseManagerImpl.KEY_USERNAME)
                            .toString(),
                        email = documentSnapshot.get(FirebaseDatabaseManagerImpl.KEY_EMAIL)
                            .toString(),
                        phoneNumber = documentSnapshot.get(FirebaseDatabaseManagerImpl.KEY_PHONE_NUMBER)
                            .toString(),
                        password = documentSnapshot.get(FirebaseDatabaseManagerImpl.KEY_PASSWORD)
                            .toString(),
                        birthday = documentSnapshot.get(FirebaseDatabaseManagerImpl.KEY_BIRTHDAY)
                            .toString(),
                        createdAt = documentSnapshot.get(FirebaseDatabaseManagerImpl.KEY_CREATED_AT)
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

    override suspend fun updateUsernameForAccountId(accountId: Long, newUsername: String) {
        accountsRepository.updateUsernameForAccountId(accountId, newUsername)
    }

}