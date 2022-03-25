package com.example.cars.utils.exceptions

sealed class AccountSearchResult

data class WrongEmailResult(
    val wrongEmail: String = "This email does not exist!"
) : AccountSearchResult()

data class WrongPasswordResult(
    val wrongPassword: String = "Wrong password!"
) : AccountSearchResult()

data class SuccessResult(
    val id: Long
) : AccountSearchResult()
