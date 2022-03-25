package com.example.cars.utils.exceptions

import java.lang.Exception

class WrongEmailException : Exception() {

    override fun getLocalizedMessage(): String {
        return "This email does not exist!"
    }
}