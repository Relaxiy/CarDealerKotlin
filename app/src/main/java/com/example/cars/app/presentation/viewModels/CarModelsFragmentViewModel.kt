package com.example.cars.app.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cars.app.domain.CarInteractor
import com.example.cars.app.domain.models.CarItem
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CarModelsFragmentViewModel(private val carInteractor: CarInteractor) : ViewModel() {

    val carsLiveData: LiveData<List<CarItem>> get() = _carsLiveData
    private val _carsLiveData = MutableLiveData<List<CarItem>>()

    init {
        loadCards()
    }

    private fun loadCards() {
        viewModelScope.launch {
            delay(1)
            _carsLiveData.value = carInteractor.getCars()
        }
    }

}