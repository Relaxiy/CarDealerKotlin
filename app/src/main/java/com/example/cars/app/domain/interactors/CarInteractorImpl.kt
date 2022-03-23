package com.example.cars.app.domain.interactors

import com.example.cars.app.data.network.api.CarApi
import com.example.cars.app.data.network.models.AddPostItem
import com.example.cars.app.domain.models.CarItem
import com.example.cars.app.domain.models.CarModel
import com.example.cars.app.domain.models.PostItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CarInteractorImpl @Inject constructor(private val carApi: CarApi) : CarInteractor {
    override suspend fun getCars(): List<CarItem> {
        return withContext(Dispatchers.IO) {
            return@withContext carApi.getCarModels().map { carResponse ->
                CarItem(
                    carModel = carResponse.carModel,
                    brandImage = carResponse.brandImage
                )
            }
        }
    }

    override suspend fun getCarModels(): List<CarModel> {
        return withContext(Dispatchers.IO) {
            return@withContext carApi.getCarModels().map { carResponse ->
                CarModel(
                    model = carResponse.carModel
                )
            }
        }
    }

    override suspend fun getPosts(): List<PostItem> {
        return withContext(Dispatchers.IO) {
            return@withContext carApi.getPosts().map { postItem ->
                PostItem(
                    img = postItem.img,
                    title = postItem.title,
                    price = postItem.price,
                    date = postItem.date
                )
            }
        }
    }

    override suspend fun sendPost(addPostItem: AddPostItem) {
        carApi.sendPost(addPostItem)
    }

}