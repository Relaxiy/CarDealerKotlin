package com.example.cars.registration.presentation.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cars.registration.data.accounts.room.models.Account
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Exception

class RegisterViewModel() : ViewModel() {

    val user: LiveData<Account> get() = _user
    private val _user = MutableLiveData<Account>()

    fun sendUser() {
        viewModelScope.launch {
            delay(1)
            try {

            } catch (e: Exception) {
                Log.e("TAG", "Exception during request -> ${e.localizedMessage}")
            }
        }
    }

    fun setUser(user: Account) {
        _user.value = user
    }

}