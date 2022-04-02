package com.example.cars.utils.actionSelectors

sealed class CreateUserPostResult{
    class PostCreationSuccess : CreateUserPostResult()
    class PostCreationFailed : CreateUserPostResult(){
        companion object{
            const val MESSAGE = "Invalid Input!"
        }
    }
}
