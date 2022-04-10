package com.example.cars.app.presentation.mainPage

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cars.app.domain.interactors.carInteractor.CarInteractor
import com.example.cars.app.domain.models.PostItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class MainPageFragmentViewModel @Inject constructor(private val carInteractor: CarInteractor) : ViewModel() {
    val posts: LiveData<List<PostItem>>get() = _posts
    private val _posts = MutableLiveData<List<PostItem>>()

    init {
        loadPosts()
    }

    private fun loadPosts(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _posts.postValue(carInteractor.getPosts())
            } catch (e: Exception) {
                Log.e("TAG", "Exception during request -> ${e.localizedMessage}")
            }
        }
    }
}