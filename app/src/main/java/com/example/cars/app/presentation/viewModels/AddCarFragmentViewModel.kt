package com.example.cars.app.presentation.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cars.app.domain.interactors.carInteractor.CarInteractor
import com.example.cars.app.data.network.models.PostResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class AddCarFragmentViewModel @Inject constructor(private val carInteractor: CarInteractor) : ViewModel() {

    val postResponse: LiveData<PostResponse> get() = _addPostItem
    private val _addPostItem = MutableLiveData<PostResponse>()

    fun createPost(postResponse: PostResponse) {
        _addPostItem.value = postResponse
        sendPost()
    }

    private fun sendPost() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                postResponse.value?.let { postItem ->
                    carInteractor.sendPost(postItem)
                }
            } catch (e: Exception) {
                Log.e("TAG", "Exception during request -> ${e.localizedMessage}")
            }
        }
    }
}