package com.example.cars.app.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cars.app.domain.models.AddPostItem

class AddCarFragmentViewModel : ViewModel() {

    val addPostItem: LiveData<AddPostItem> get() = _addPostItem
    private val _addPostItem = MutableLiveData<AddPostItem>()

    fun createPost(addPostItem: AddPostItem){
        _addPostItem.value = addPostItem

    }
}