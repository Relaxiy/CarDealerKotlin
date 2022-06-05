package com.example.cars.registration.presentation.login

import android.os.Bundle
import android.widget.ProgressBar
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.cars.CarApplication
import com.example.cars.app.presentation.MainActivity
import com.example.cars.app.presentation.personalPage.UserSharedViewModel
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

    @Inject
    lateinit var userSharedViewModel: UserSharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        CarApplication.initAppComponentWithSharedViewModel(this, this)
        CarApplication.appComponentWithSharedViewModel.inject(this)

        if (sharedPreferences.getSign()){
            binding.inputLoginEmail.setText(sharedPreferences.getEmail())
            binding.inputLoginPassword.setText(sharedPreferences.getPassword())
        }
    }

    override fun onStart() {
        super.onStart()

        login()
        toRegister()
    }

    private fun login() {
        loginButton.setOnClickListener {
            binding.progressLogin.visibility = ProgressBar.VISIBLE
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
                    userSharedViewModel.shareAccountIntoPersonalPage(
                        accountSearchResult.account.username,
                        accountSearchResult.account.email,
                        accountSearchResult.account.birthday,
                        accountSearchResult.account.password,
                        accountSearchResult.account.createdAt
                    )
                    sharedPreferences.saveSign( true)
                    sharedPreferences.saveEmail(binding.inputLoginEmail.text.toString())
                    sharedPreferences.savePassword(binding.inputLoginPassword.text.toString())
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