package com.example.cars.app.domain

import com.example.cars.app.data.api.CarApi
import com.example.cars.app.domain.models.AddPostItem
import com.example.cars.app.domain.models.CarItem
import com.example.cars.app.domain.models.CarModel
import com.example.cars.app.domain.models.PostItem
import retrofit2.Call

class CarInteractorImpl(private val repository: CarApi) : CarInteractor {
    override suspend fun getCars(): List<CarItem> {
        return repository.getCarModels().blockingGet().map{ carsResponce->
            CarItem(
                carModel = carsResponce.carModel,
                brandImage = carsResponce.brandImage
            )
        }
    }

    override suspend fun getCarModels(): List<CarModel> {
        return repository.getCarModels().blockingGet().map { carModel ->
            CarModel(
                model = carModel.carModel
            )
        }
    }

    override suspend fun getPosts(): List<PostItem> {
        return repository.getPosts().blockingGet().map { postItem ->
            PostItem(
                img = postItem.img,
                title = postItem.title,
                price = postItem.price,
                date = postItem.date
            )
        }
    }

    override suspend fun sendPost(addPostItem: AddPostItem): Call<AddPostItem> {
        return repository.sendPost(addPostItem)
    }

}