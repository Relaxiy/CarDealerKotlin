package com.example.cars.app.presentation.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cars.app.domain.CarInteractor
import com.example.cars.app.data.models.AddPostItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class AddCarFragmentViewModel(private val carInteractor: CarInteractor) : ViewModel() {

    val addPostItem: LiveData<AddPostItem> get() = _addPostItem
    private val _addPostItem = MutableLiveData<AddPostItem>()

    fun createPost(addPostItem: AddPostItem) {
        _addPostItem.value = addPostItem
        sendPost()
    }

    private fun sendPost() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                addPostItem.value?.let { postItem ->
                    carInteractor.sendPost(postItem)
                }
            } catch (e: Exception) {
                Log.e("TAG", "Exception during request -> ${e.localizedMessage}")
            }
        }
    }
}