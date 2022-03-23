package com.example.cars.registration.presentation.viewModels


import android.accounts.AuthenticatorException
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cars.registration.domain.interactor.AccountsInteractor
import com.example.cars.registration.domain.models.AccountSignIn
import com.example.cars.utils.ext.isEmail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginActivityViewModel @Inject constructor(private val accountsInteractor: AccountsInteractor) : ViewModel() {

    fun signIn(accountSignIn: AccountSignIn) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val accountId = accountsInteractor.findAccountIdByEmailAndPassword(accountSignIn)
            } catch (e: AuthenticatorException) {
                Log.e("TAG", "Exception during request -> ${e.localizedMessage}")
            }
        }
    }

    fun validateSignIn(accountSignIn: AccountSignIn): Boolean {
        accountSignIn.apply {
            return email.isEmpty() ||
                    password.isEmpty() ||
                    !email.isEmail() ||
                    password.length < 8
        }
    }

}