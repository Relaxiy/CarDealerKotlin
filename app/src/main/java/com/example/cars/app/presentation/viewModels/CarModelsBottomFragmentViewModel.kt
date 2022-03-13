package com.example.cars.app.presentation.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cars.app.domain.CarInteractor
import com.example.cars.app.domain.models.CarModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Exception

class CarModelsBottomFragmentViewModel(private val carInteractor: CarInteractor) : ViewModel() {

    val carModelsLiveData: LiveData<List<CarModel>> get() = _carModelsLiveData
    private val _carModelsLiveData = MutableLiveData<List<CarModel>>()

    init {
        loadCards()
    }

    private fun loadCards() {
        viewModelScope.launch {
            try {
                delay(1)
                _carModelsLiveData.value = carInteractor.getCarModels()
            } catch (e: Exception) {
                Log.e("TAG", "Exception during request -> ${e.localizedMessage}")
            }
        }
    }

}