package com.example.cars.registration.presentation.viewModels

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteConstraintException
import android.database.sqlite.SQLiteException
import android.widget.EditText
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cars.app.presentation.MainActivity
import com.example.cars.registration.domain.interactor.AccountsInteractor
import com.example.cars.registration.domain.models.SignUpData
import com.example.cars.utils.actionSelectors.RegistrationActionSelector
import com.example.cars.utils.actionSelectors.RegistrationActionSelector.*
import com.example.cars.utils.ext.dialog
import com.example.cars.utils.ext.isEmail
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class RegisterActivityViewModel @Inject constructor(private val accountsInteractor: AccountsInteractor) :
    ViewModel() {

    val result: LiveData<RegistrationActionSelector> get() = _result
    private val _result = MutableLiveData<RegistrationActionSelector>()

    fun saveAccount(
        username: String,
        email: String,
        birthday: String,
        password: String,
        repeatPassword: String
    ) {
        val account = createAccount(username, email, birthday, password, repeatPassword)
        if (!validate(account)) {
            viewModelScope.launch {
                _result.value = viewModelScope.async {
                    try {
                        accountsInteractor.createAccount(account)
                        return@async OpenMainActivity
                    } catch (e: SQLiteException) {
                        return@async ShowExistingEmailDialog()
                    }
                }.await()
            }
        } else {
            _result.value = ShowInvalidInputDialog()
        }
    }

    private fun createAccount(
        username: String,
        email: String,
        birthday: String,
        password: String,
        repeatPassword: String
    ): SignUpData {
        return SignUpData(
            username = username,
            email = email,
            birthday = birthday,
            password = password,
            repeatPassword = repeatPassword
        )
    }

    private fun validate(signUpData: SignUpData): Boolean {
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

}