package com.example.cars.app.presentation.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cars.app.domain.interactors.CarInteractor
import com.example.cars.app.domain.models.CarModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class CarModelsBottomFragmentViewModel @Inject constructor(private val carInteractor: CarInteractor) : ViewModel() {

    val carModelsLiveData: LiveData<List<CarModel>> get() = _carModelsLiveData
    private val _carModelsLiveData = MutableLiveData<List<CarModel>>()

    init {
        loadCards()
    }

    private fun loadCards() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _carModelsLiveData.postValue(carInteractor.getCarModels())
            } catch (e: Exception) {
                Log.e("TAG", "Exception during request -> ${e.localizedMessage}")
            }
        }
    }

}