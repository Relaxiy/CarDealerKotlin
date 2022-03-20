package com.example.cars.registration.presentation.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cars.registration.domain.interactor.AccountsInteractor
import com.example.cars.registration.domain.models.Account
import com.example.cars.registration.domain.models.SignUpData
import com.example.cars.utils.ext.isEmail
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Exception

class RegisterViewModel(private val accountsInteractor: AccountsInteractor) : ViewModel() {

    val signUpData: LiveData<SignUpData> get() = _signUpData
    private val _signUpData = MutableLiveData<SignUpData>()


    fun saveAccount() {
        viewModelScope.launch {
            delay(1)
            try {
                signUpData.value?.let { signUpData ->
                    accountsInteractor.createAccount(signUpData)
                }
            } catch (e: Exception) {
                Log.e("TAG", "Exception during request -> ${e.localizedMessage}")
            }
        }
    }

//    fun validate(signUpData: SignUpData): Boolean {
//        signUpData.apply {
//            return username.isEmpty() ||
//                    email.isEmpty() ||
//                    !email.isEmail() ||
//                    birthday.isEmpty() ||
//                    password.isEmpty() ||
//                    repeatPassword.isEmpty() ||
//                    password != signUpData.repeatPassword ||
//                    password.length < 8
//        }
//    }

    fun setAccount(signUpData: SignUpData) {
        _signUpData.value = signUpData
    }

}