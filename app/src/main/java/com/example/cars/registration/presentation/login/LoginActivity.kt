package com.example.cars.registration.presentation.login

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.cars.app.presentation.MainActivity
import com.example.cars.databinding.ActivityLoginBinding
import com.example.cars.registration.presentation.register.RegisterActivity
import com.example.cars.registration.presentation.login.actionSelector.AccountSearchResult.*
import com.example.cars.registration.presentation.utils.SharedPreferencesManager
import com.example.cars.utils.ext.appComponent
import com.example.cars.utils.ext.dialog
import com.example.cars.utils.ext.openActivity
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {

    private val loginActivityViewModel: LoginActivityViewModel by viewModels {
        appComponent.viewModelsFactory()
    }

    private lateinit var binding: ActivityLoginBinding

    @Inject
    lateinit var sharedPreferences: SharedPreferencesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        appComponent.inject(this)

        if (sharedPreferences.get("auth")){
            openActivity(MainActivity::class.java)
        }
    }

    override fun onStart() {
        super.onStart()
        login()
        toRegister()
    }

    private fun login() {
        loginButton.setOnClickListener {
            loginActivityViewModel.signIn(
                binding.inputLoginEmail.text.toString(),
                binding.inputLoginPassword.text.toString()
            )
        }

        loginActivityViewModel.searchResult.observe(this) { accountSearchResult ->
            when (accountSearchResult) {
                is WrongResult -> dialog(WrongResult().error)
                is InvalidInput -> dialog(InvalidInput().invalidInput)
                is SuccessResult -> {
                    sharedPreferences.save("auth", true)
                    openActivity(MainActivity::class.java)
                }
            }
        }
    }

    private fun toRegister() {
        toRegister.setOnClickListener {
            openActivity(RegisterActivity::class.java)
        }
    }

}