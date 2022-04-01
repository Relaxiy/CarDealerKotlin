package com.example.cars.registration.presentation.viewModels

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteConstraintException
import android.widget.EditText
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cars.app.presentation.MainActivity
import com.example.cars.registration.domain.interactor.AccountsInteractor
import com.example.cars.registration.domain.models.SignUpData
import com.example.cars.utils.ext.dialog
import com.example.cars.utils.ext.isEmail
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class RegisterActivityViewModel @Inject constructor(private val accountsInteractor: AccountsInteractor) :
    ViewModel() {

    val signUpData: LiveData<SignUpData> get() = _signUpData
    private val _signUpData = MutableLiveData<SignUpData>()

    fun setAccount(signUpData: SignUpData, activity: FragmentActivity) {
        _signUpData.value = signUpData
        saveAccount(activity)
    }

    private fun saveAccount(activity: FragmentActivity) {
        viewModelScope.launch {
            try {
                signUpData.value?.let { signUpData ->
                    accountsInteractor.createAccount(signUpData)
                }
                val intent = Intent(activity, MainActivity::class.java)
                activity.startActivity(intent)
            } catch (e: SQLiteConstraintException) {
                activity.dialog("This account already registered!")
            }
        }

    }

    fun initDate(inputDate: EditText, context: Context) {
        val calendar = Calendar.getInstance()
        val datePicker = DatePickerDialog.OnDateSetListener { _, year, month, day ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, day)
            updateLabel(calendar, inputDate)
        }
        inputDate.setOnClickListener {
            DatePickerDialog(
                context,
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

    fun validate(signUpData: SignUpData): Boolean {
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