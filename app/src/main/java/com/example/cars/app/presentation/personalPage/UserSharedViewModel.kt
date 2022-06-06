package com.example.cars.app.presentation.personalPage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cars.registration.domain.models.Account

class UserSharedViewModel : ViewModel() {

    val account: LiveData<Account> get() = _account
    private val _account = MutableLiveData<Account>()

    fun shareAccountIntoPersonalPage(
        username: String,
        email: String,
        phoneNumber: String,
        birthday: String,
        password: String,
        createdAt: String
    ) {
        _account.value = Account(
            username = username,
            email = email,
            phoneNumber = phoneNumber,
            birthday = birthday,
            password = password,
            createdAt = createdAt
        )
    }
}