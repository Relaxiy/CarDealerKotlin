package com.example.cars.registration.presentation.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.cars.R
import com.example.cars.app.presentation.MainActivity
import com.example.cars.registration.domain.models.SignInData
import com.example.cars.registration.presentation.viewModels.LoginActivityViewModel
import com.example.cars.utils.actionSelectors.AccountSearchResult
import com.example.cars.utils.actionSelectors.AccountSearchResult.*
import com.example.cars.utils.ext.appComponent
import com.example.cars.utils.ext.dialog
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private val loginActivityViewModel: LoginActivityViewModel by viewModels {
        appComponent.viewModelsFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    override fun onStart() {
        super.onStart()
        login()
        toRegister()
    }

    private fun login() {
        loginButton.setOnClickListener {
            loginActivityViewModel.signIn(
                inputLoginEmail.text.toString(),
                inputLoginPassword.text.toString()
            )
        }

        loginActivityViewModel.searchResult.observe(this) { accountSearchResult ->
            when (accountSearchResult) {
                is WrongEmailResult -> dialog(WrongEmailResult().wrongEmail)
                is WrongPasswordResult -> dialog(WrongPasswordResult().wrongPassword)
                is InvalidInput -> dialog(InvalidInput().invalidInput)
                is SuccessResult -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }

    private fun toRegister() {
        toRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

}