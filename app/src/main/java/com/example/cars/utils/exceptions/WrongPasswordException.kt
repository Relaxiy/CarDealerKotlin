package com.example.cars.utils.exceptions

import java.lang.Exception

class WrongPasswordException : Exception() {
    override fun getLocalizedMessage(): String {
        return "Wrong password!"
    }
}