package com.example.cars.app.data.repository

import com.example.cars.app.data.RetrofitInstance
import com.example.cars.app.data.api.CarApi
import com.example.cars.app.domain.models.AddPostItem
import com.example.cars.app.domain.models.CarItem
import com.example.cars.app.domain.models.CarModel
import com.example.cars.app.domain.models.PostItem
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call

class CarRepository : CarApi {
    override suspend fun getCarModels(): Single<List<CarItem>> {
        return withContext(Dispatchers.IO) {
            return@withContext RetrofitInstance.api.getCarModels()
                .subscribeOn(Schedulers.io())
        }
    }

    override suspend fun getPosts(): Single<List<PostItem>> {
        return withContext(Dispatchers.IO) {
            return@withContext RetrofitInstance.api.getPosts()
                .subscribeOn(Schedulers.io())
        }
    }

    override suspend fun sendPost(addPostItem: AddPostItem): Call<AddPostItem> {
        return withContext(Dispatchers.IO) {
            return@withContext RetrofitInstance.api.sendPost(addPostItem)
        }
    }

}