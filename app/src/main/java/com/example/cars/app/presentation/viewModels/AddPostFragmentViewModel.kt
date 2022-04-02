package com.example.cars.app.presentation.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cars.app.domain.interactors.carInteractor.CarInteractor
import com.example.cars.app.data.network.models.PostResponse
import com.example.cars.app.domain.interactors.userPostsInteractor.UserPostsInteractor
import com.example.cars.app.domain.models.UserPost
import com.example.cars.utils.actionSelectors.CreateUserPostResult
import com.example.cars.utils.actionSelectors.CreateUserPostResult.PostCreationFailed
import com.example.cars.utils.actionSelectors.CreateUserPostResult.PostCreationSuccess
import com.example.cars.utils.ext.isEmail
import com.google.android.material.appbar.AppBarLayout
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class AddPostFragmentViewModel @Inject constructor(
    private val userPostsInteractor: UserPostsInteractor
) : ViewModel() {

    val userPost: LiveData<UserPost> get() = _userPost
    private val _userPost = MutableLiveData<UserPost>()

    val validateUserPostResponse: LiveData<CreateUserPostResult> get() = _validateUserPostResponse
    private val _validateUserPostResponse = MutableLiveData<CreateUserPostResult>()

    fun savePost(
        images: String?,
        title: String,
        carModel: String,
        description: String,
        price: String,
        personName: String,
        email: String,
        phoneNumber: String
    ) {
        val post = createPost(
            images,
            title,
            carModel,
            description,
            price,
            personName,
            email,
            phoneNumber
        )
        _validateUserPostResponse.value = if (!validate(post)) {
            viewModelScope.launch {
                userPostsInteractor.saveUserPost(post)
            }
            PostCreationSuccess()
        } else {
            PostCreationFailed()
        }
    }

    private fun createPost(
        images: String?,
        title: String,
        carModel: String,
        description: String,
        price: String,
        personName: String,
        email: String,
        phoneNumber: String
    ): UserPost {
        return UserPost(
            images = images,
            title = title,
            carModel = carModel,
            description = description,
            price = price,
            personName = personName,
            email = email,
            phoneNumber = phoneNumber
        )
    }

    private fun validate(userPost: UserPost): Boolean {
        userPost.apply {
            return title.isEmpty() ||
                    carModel.isEmpty() ||
                    description.isEmpty() ||
                    price.isEmpty() ||
                    personName.isEmpty() ||
                    email.isEmpty() ||
                    phoneNumber.isEmpty() ||
                    !email.isEmail()
        }
    }
}