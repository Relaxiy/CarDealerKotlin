package com.example.cars.registration.presentation.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.cars.app.presentation.MainActivity
import com.example.cars.R
import com.example.cars.registration.domain.models.SignUpData
import com.example.cars.registration.presentation.viewModels.LoginActivityViewModel
import com.example.cars.registration.presentation.viewModels.RegisterActivityViewModel
import com.example.cars.utils.ext.appComponent
import com.example.cars.utils.ext.dialog
import kotlinx.android.synthetic.main.activity_register.*
import javax.inject.Inject

class RegisterActivity : AppCompatActivity() {


    private val registerActivityViewModel: RegisterActivityViewModel by viewModels {
        appComponent.viewModelsFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    override fun onStart() {
        super.onStart()
        registerActivityViewModel.initDate(inputDate, this)
        register()
        toLogin()
    }

    private fun register() {
        registrationButton.setOnClickListener {
            val account = createAccount()
            if (registerActivityViewModel.validate(account)) {
                dialog("Fields not valid!")
            } else {
                registerActivityViewModel.setAccount(account, this)
            }
        }
    }

    private fun toLogin() {
        toLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun createAccount(): SignUpData {
        return SignUpData(
            username = inputUsername.text.toString(),
            email = inputEmail.text.toString(),
            birthday = inputDate.text.toString(),
            password = inputPasswordFirst.text.toString(),
            repeatPassword = inputPasswordSecond.text.toString()
        )
    }
}