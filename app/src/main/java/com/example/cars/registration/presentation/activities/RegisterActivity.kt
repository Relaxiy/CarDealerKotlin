package com.example.cars.registration.presentation.activities

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.cars.app.presentation.MainActivity
import com.example.cars.R
import com.example.cars.registration.presentation.viewModels.RegisterActivityViewModel
import com.example.cars.utils.actionSelectors.RegistrationActionSelector.*
import com.example.cars.utils.ext.appComponent
import com.example.cars.utils.ext.dialog
import kotlinx.android.synthetic.main.activity_register.*
import java.text.SimpleDateFormat
import java.util.*

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
        initDate()
        register()
        toLogin()
    }

    private fun initDate() {
        val calendar = Calendar.getInstance()
        val datePicker = DatePickerDialog.OnDateSetListener { _, year, month, day ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, day)
            updateLabel(calendar, inputDate)
        }
        inputDate.setOnClickListener {
            DatePickerDialog(
                this,
                datePicker,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH),
            ).show()
        }
    }

    private fun updateLabel(calendar: Calendar, inputDate: EditText) {
        val format = "dd/MM/yyyy"
        val sdf = SimpleDateFormat(format, Locale.UK)
        inputDate.setText(sdf.format(calendar.time))
    }

    private fun register() {
        registrationButton.setOnClickListener {
            registerActivityViewModel.saveAccount(
                inputUsername.text.toString(),
                inputEmail.text.toString(),
                inputDate.text.toString(),
                inputPasswordFirst.text.toString(),
                inputPasswordSecond.text.toString()
            )
        }
        registerActivityViewModel.result.observe(this) { registrationActionSelector ->
            when (registrationActionSelector) {
                is OpenMainActivity -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
                is ShowInvalidInputDialog -> dialog(ShowInvalidInputDialog.MESSAGE)
                is ShowExistingEmailDialog -> dialog(ShowExistingEmailDialog.MESSAGE)
            }
        }
    }

    private fun toLogin() {
        toLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

}