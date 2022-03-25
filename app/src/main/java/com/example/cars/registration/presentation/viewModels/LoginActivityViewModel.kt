package com.example.cars.registration.presentation.viewModels


import android.content.Intent
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cars.app.presentation.MainActivity
import com.example.cars.registration.domain.interactor.AccountsInteractor
import com.example.cars.registration.domain.models.SignInData
import com.example.cars.utils.ext.dialog
import com.example.cars.utils.ext.isEmail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class LoginActivityViewModel @Inject constructor(private val accountsInteractor: AccountsInteractor) : ViewModel() {

    fun signIn(signInData: SignInData, activity: FragmentActivity) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                accountsInteractor.findAccountIdByEmailAndPassword(signInData)
                val intent = Intent(activity, MainActivity::class.java)
                activity.startActivity(intent)
            } catch (e: Exception) {
                activity.dialog(e.localizedMessage)
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