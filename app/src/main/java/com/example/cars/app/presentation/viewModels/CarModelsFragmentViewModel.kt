package com.example.cars.app.presentation.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cars.app.domain.CarInteractor
import com.example.cars.app.domain.models.CarItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Exception

class CarModelsFragmentViewModel(private val carInteractor: CarInteractor) : ViewModel() {

    val carsLiveData: LiveData<List<CarItem>> get() = _carsLiveData
    private val _carsLiveData = MutableLiveData<List<CarItem>>()

    init {
        loadCards()
    }

    private fun loadCards() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _carsLiveData.postValue(carInteractor.getCars())
            } catch (e: Exception) {
                Log.e("TAG", "Exception during request -> ${e.localizedMessage}")
            }
        }
    }

}