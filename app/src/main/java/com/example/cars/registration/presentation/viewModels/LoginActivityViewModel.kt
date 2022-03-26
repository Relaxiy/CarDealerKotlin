package com.example.cars.registration.presentation.viewModels


import android.content.Intent
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cars.app.presentation.MainActivity
import com.example.cars.registration.domain.interactor.AccountsInteractor
import com.example.cars.registration.domain.models.Account
import com.example.cars.registration.domain.models.SignInData
import com.example.cars.utils.exceptions.AccountSearchResult
import com.example.cars.utils.exceptions.AccountSearchResult.*
import com.example.cars.utils.ext.dialog
import com.example.cars.utils.ext.isEmail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginActivityViewModel @Inject constructor(
    private val accountsInteractor: AccountsInteractor
) : ViewModel() {

    val account: LiveData<Account> get() = _account
    private val _account = MutableLiveData<Account>()

    fun signIn(signInData: SignInData, activity: FragmentActivity) {
        viewModelScope.launch(Dispatchers.IO) {

            when (val response = accountsInteractor.findAccountIdByEmailAndPassword(signInData)) {
                is WrongEmailResult -> activity.dialog(WrongEmailResult().wrongEmail)
                is WrongPasswordResult -> activity.dialog(WrongPasswordResult().wrongPassword)
                is SuccessResult -> {
                    accountsInteractor.getAccountById(response.id).collect { account ->
                        _account.postValue(account)
                    }
                    val intent = Intent(activity, MainActivity::class.java)
                    activity.startActivity(intent)
                }
            }
        }
    }

    fun validateSignIn(signInData: SignInData): Boolean {
        signInData.apply {
            return email.isEmpty() ||
                    password.isEmpty() ||
                    !email.isEmail() ||
                    password.length < 8
        }
    }

}