package com.example.cars.registration.presentation.viewModels


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cars.registration.data.room.RoomDbInstance
import com.example.cars.registration.domain.interactor.AccountsInteractorImpl
import com.example.cars.registration.domain.models.AccountSignIn
import com.example.cars.utils.ext.isEmail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class LoginActivityViewModel : ViewModel() {

    private val accountsInteractor by lazy {
        AccountsInteractorImpl(
            accountsDao = RoomDbInstance.dataBase.getAccountsDao()
        )
    }

    fun signIn(accountSignIn: AccountSignIn) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                accountsInteractor.findAccountIdByEmailAndPassword(accountSignIn)
            } catch (e: Exception) {
                Log.e("TAG", "Exception during request -> ${e.localizedMessage}")
            }
        }
    }

    fun validateSignIn(accountSignIn: AccountSignIn): Boolean {
        accountSignIn.apply {
            return email.isEmpty() || password.isEmpty() || !email.isEmail()
        }
    }

}