package com.example.cars.app.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cars.app.domain.CarInteractor
import com.example.cars.app.domain.models.CarModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CarModelsBottomFragmentViewModel(private val carInteractor: CarInteractor) : ViewModel() {

    val carModelsLiveData: LiveData<List<CarModel>> get() = _carModelsLiveData
    private val _carModelsLiveData = MutableLiveData<List<CarModel>>()

    init {
        loadCards()
    }

    private fun loadCards() {
        viewModelScope.launch {
            delay(1)
            _carModelsLiveData.value = carInteractor.getCarModels()
        }
    }

}