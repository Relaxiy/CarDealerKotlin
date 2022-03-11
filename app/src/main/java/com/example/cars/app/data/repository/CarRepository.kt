package com.example.cars.app.data.repository

import com.example.cars.app.data.RetrofitInstance
import com.example.cars.app.data.api.CarApi
import com.example.cars.app.domain.models.CarItem
import com.example.cars.app.domain.models.CarModel
import com.example.cars.app.domain.models.PostItem
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import retrofit2.Call

class CarRepository : CarApi {
    override fun getCarModels(): Single<List<CarItem>> {
        return RetrofitInstance.api.getCarModels()
            .subscribeOn(Schedulers.io())
    }

    override fun getPosts(): Single<List<PostItem>> {
        return RetrofitInstance.api.getPosts()
            .subscribeOn(Schedulers.io())
    }

    override fun sendPost(): Call<PostItem> {
        return RetrofitInstance.api.sendPost()
    }

}