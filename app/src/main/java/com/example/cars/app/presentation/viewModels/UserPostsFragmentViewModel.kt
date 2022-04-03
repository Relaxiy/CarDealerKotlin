package com.example.cars.app.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cars.app.domain.interactors.userPostsInteractor.UserPostsInteractor
import com.example.cars.app.domain.models.UserPost
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserPostsFragmentViewModel @Inject constructor(
    private val userPostsInteractor: UserPostsInteractor
) : ViewModel() {

    val userPosts: LiveData<List<UserPost>> get() = _userPosts
    private val _userPosts = MutableLiveData<List<UserPost>>()

    init {
        getUserPosts()
    }

    private fun getUserPosts(){
        viewModelScope.launch {
            _userPosts.postValue(userPostsInteractor.getUserPosts())
        }
    }
}