package com.example.cars.app.presentation.userPosts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cars.app.domain.interactors.userPostsInteractor.UserPostsInteractor
import com.example.cars.app.domain.models.UserPost
import com.example.cars.app.domain.models.UserPostResponse
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserPostsFragmentViewModel @Inject constructor(
    private val userPostsInteractor: UserPostsInteractor
) : ViewModel() {

    val userPosts: LiveData<List<UserPostResponse>> get() = _userPosts
    private val _userPosts = MutableLiveData<List<UserPostResponse>>()

    fun getUserPosts(documentPath: String){
        viewModelScope.launch {
            viewModelScope.async {
                _userPosts.postValue(userPostsInteractor.getUserPosts())
            }.await()
            viewModelScope.async {
                if (_userPosts.value?.isEmpty() == true){
                    _userPosts.postValue()
                }
            }.await()
        }
    }

    fun deleteUserPost(userPostResponse: UserPostResponse){

    }
}