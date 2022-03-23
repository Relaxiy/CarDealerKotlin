package com.example.cars.app.presentation.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cars.app.domain.interactors.CarInteractor
import com.example.cars.app.domain.models.CarItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class CarModelsFragmentViewModel @Inject constructor(private val carInteractor: CarInteractor) : ViewModel() {

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