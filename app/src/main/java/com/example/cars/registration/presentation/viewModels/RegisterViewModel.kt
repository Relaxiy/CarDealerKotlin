package com.example.cars.registration.presentation.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cars.registration.data.room.RoomDbInstance
import com.example.cars.registration.domain.interactor.AccountsInteractor
import com.example.cars.registration.domain.interactor.AccountsInteractorImpl
import com.example.cars.registration.domain.models.Account
import com.example.cars.registration.domain.models.SignUpData
import com.example.cars.utils.ext.isEmail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Exception

class RegisterViewModel() : ViewModel() {

    val signUpData: LiveData<SignUpData> get() = _signUpData
    private val _signUpData = MutableLiveData<SignUpData>()

    private val accountsInteractor by lazy {
        AccountsInteractorImpl(
            accountsDao = RoomDbInstance.dataBase.getAccountsDao()
        )
    }

    fun saveAccount() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                signUpData.value?.let { signUpData ->
                    accountsInteractor.createAccount(signUpData)
                }
            } catch (e: Exception) {
                Log.e("TAG", "Exception during request -> ${e.localizedMessage}")
            }
        }
    }

    fun validate(signUpData: SignUpData): Boolean {
        signUpData.apply {
            return username.isEmpty() ||
                    email.isEmpty() ||
                    !email.isEmail() ||
                    birthday.isEmpty() ||
                    password.isEmpty() ||
                    repeatPassword.isEmpty() ||
                    password != signUpData.repeatPassword ||
                    password.length < 8
        }
    }

    fun setAccount(signUpData: SignUpData) {
        _signUpData.value = signUpData
    }

}