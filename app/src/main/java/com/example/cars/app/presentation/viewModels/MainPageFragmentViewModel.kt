package com.example.cars.app.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cars.app.domain.CarInteractor
import com.example.cars.app.domain.models.PostItem
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainPageFragmentViewModel(private val interactor: CarInteractor) : ViewModel() {
    val posts: LiveData<List<PostItem>>get() = _posts
    private val _posts = MutableLiveData<List<PostItem>>()

    init {
        loadPosts()
    }

    private fun loadPosts(){
        viewModelScope.launch {
            delay(1)
            _posts.value = interactor.getPosts()
        }
    }
}