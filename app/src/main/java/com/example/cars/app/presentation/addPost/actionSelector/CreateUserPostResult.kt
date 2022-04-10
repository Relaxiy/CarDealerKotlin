package com.example.cars.app.presentation.addPost.actionSelector

sealed class CreateUserPostResult{
    class PostCreationSuccess : CreateUserPostResult()
    class PostCreationFailed : CreateUserPostResult(){
        companion object{
            const val MESSAGE = "Invalid Input!"
        }
    }
}
