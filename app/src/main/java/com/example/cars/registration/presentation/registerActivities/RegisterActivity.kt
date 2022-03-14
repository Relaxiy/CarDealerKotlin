package com.example.cars.registration.presentation.registerActivities

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cars.MainActivity
import com.example.cars.R
import com.example.cars.databinding.ActivityMainBinding
import com.example.cars.registration.domain.models.User
import com.example.cars.registration.presentation.viewModels.LoginViewModel
import com.example.cars.utils.ext.dialog
import com.example.cars.utils.ext.isEmail
import kotlinx.android.synthetic.main.activity_register.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    override fun onStart() {
        super.onStart()
        initDate()
        register()
    }

    private val loginViewModel: LoginViewModel by viewModel()

    private fun initDate() {
        val calendar = Calendar.getInstance()
        val datePicker = DatePickerDialog.OnDateSetListener { view, year, month, day ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, day)
            updateLabel(calendar)
        }
        inputDate.setOnClickListener {
            DatePickerDialog(
                this,
                datePicker,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
    }

    private fun updateLabel(calendar: Calendar) {
        val format = "dd/MM/yyyy"
        val sdf = SimpleDateFormat(format, Locale.UK)
        inputDate.setText(sdf.format(calendar.time))
    }

    private fun register() {
        registrationButton.setOnClickListener {
            if (inputUsername.text.isEmpty() ||
                inputEmail.text.isEmpty() ||
                inputDate.text.isEmpty() ||
                inputPasswordFirst.text.isEmpty() ||
                inputPasswordFirst.text.isEmpty() ||
                inputPasswordSecond.text.isEmpty() ||
                inputPasswordFirst.text.toString() != inputPasswordSecond.text.toString() ||
                !inputEmail.text.toString().isEmail()
            ) {
                dialog()
            } else {
                loginViewModel.setUser(
                    createUser()
                )
                loginViewModel.sendUser()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun createUser(): User {
        return User(
            username = inputUsername.text.toString(),
            email = inputEmail.text.toString(),
            birthday = inputDate.text.toString(),
            password = inputPasswordFirst.text.toString()
        )
    }
}