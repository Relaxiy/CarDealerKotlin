package com.example.cars.registration.data.repository

import com.example.cars.registration.data.RetrofitRegistrationInstance
import com.example.cars.registration.data.api.UserApi
import com.example.cars.registration.domain.models.PostedUser
import retrofit2.Call

class UserRepository : UserApi {
    override fun sendUser(postedUser: PostedUser): Call<PostedUser> {
       return RetrofitRegistrationInstance.api.sendUser(postedUser)
    }
}