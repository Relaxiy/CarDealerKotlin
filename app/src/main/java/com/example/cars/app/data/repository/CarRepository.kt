package com.example.cars.app.data.repository

import com.example.cars.app.data.RetrofitInstance
import com.example.cars.app.data.api.CarApi
import com.example.cars.app.domain.models.CarItem
import com.example.cars.app.domain.models.CarModel
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class CarRepository : CarApi {
    override suspend fun getCars(): Single<List<CarItem>> {
        return RetrofitInstance.api.getCars()
            .subscribeOn(Schedulers.io())
    }

    override suspend fun getCarModels(): Single<List<CarModel>> {
        return RetrofitInstance.api.getCarModels()
            .subscribeOn(Schedulers.io())
    }

}