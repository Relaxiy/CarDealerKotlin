package com.example.cars.registration.presentation.viewModels

import android.app.DatePickerDialog
import android.content.Context
import android.util.Log
import android.widget.EditText
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cars.registration.data.room.RoomDbInstance
import com.example.cars.registration.domain.interactor.AccountsInteractor
import com.example.cars.registration.domain.interactor.AccountsInteractorImpl
import com.example.cars.registration.domain.models.Account
import com.example.cars.registration.domain.models.SignUpData
import com.example.cars.utils.ext.isEmail
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

class RegisterActivityViewModel() : ViewModel() {

    val signUpData: LiveData<SignUpData> get() = _signUpData
    private val _signUpData = MutableLiveData<SignUpData>()

    private val accountsInteractor by lazy {
        AccountsInteractorImpl(
            accountsDao = RoomDbInstance.dataBase.getAccountsDao()
        )
    }

    private fun saveAccount() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                signUpData.value?.let { signUpData ->
                    accountsInteractor.createAccount(signUpData)
                }
            } catch (e: Exception) {
                Log.e("TAG", "Exception during request -> ${e.localizedMessage}")
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
                calendar.get(Calendar.DAY_OF_MONTH)
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

    fun setAccount(signUpData: SignUpData) {
        _signUpData.value = signUpData
        saveAccount()
    }

}