package com.example.cars.registration.presentation.registerActivities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cars.R
import com.example.cars.app.presentation.MainActivity
import com.example.cars.registration.domain.models.AccountSignIn
import com.example.cars.registration.presentation.viewModels.LoginActivityViewModel
import com.example.cars.utils.ext.appComponent
import com.example.cars.utils.ext.dialog
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {

    @Inject
    lateinit var loginActivityViewModel: LoginActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        appComponent.inject(this)
    }

    override fun onStart() {
        super.onStart()
        login()
        toRegister()
    }

    private fun login() {
        loginButton.setOnClickListener {
            val signInAccount = createSignInAccount()
            if (loginActivityViewModel.validateSignIn(signInAccount)) {
                dialog()
            } else {
                loginActivityViewModel.signIn(signInAccount)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun toRegister() {
        toRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun createSignInAccount(): AccountSignIn {
        return AccountSignIn(
            email = inputLoginEmail.text.toString(),
            password = inputLoginPassword.text.toString()
        )
    }
}