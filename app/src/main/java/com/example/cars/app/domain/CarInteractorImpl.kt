package com.example.cars.app.domain

import com.example.cars.app.data.api.CarApi
import com.example.cars.app.domain.models.CarItem
import com.example.cars.app.domain.models.CarModel

class CarInteractorImpl(private val repository: CarApi) : CarInteractor {
    override suspend fun getCars(): List<CarItem> {
        return repository.getCars().blockingGet().map{ carsResponce->
            CarItem(
                carModel = carsResponce.carModel,
                brandImage = carsResponce.brandImage
            )
        }
    }

    override suspend fun getCarModels(): List<CarModel> {
        return repository.getCarModels().blockingGet().map { carModel ->
            CarModel(
                model = carModel.model
            )
        }
    }
}