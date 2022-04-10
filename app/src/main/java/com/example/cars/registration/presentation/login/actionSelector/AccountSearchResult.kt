package com.example.cars.registration.presentation.login.actionSelector

sealed class AccountSearchResult{

    data class WrongEmailResult(
        val wrongEmail: String = "This email does not exist!"
    ) : AccountSearchResult()

    data class WrongPasswordResult(
        val wrongPassword: String = "Wrong password!"
    ) : AccountSearchResult()

    data class InvalidInput(
        val invalidInput: String = "Invalid input!"
    ) : AccountSearchResult()

    data class SuccessResult(
        val id: Long
    ) : AccountSearchResult()

}
