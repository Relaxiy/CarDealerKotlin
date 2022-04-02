package com.example.cars.utils.actionSelectors

sealed class RegistrationActionSelector{
    object OpenMainActivity : RegistrationActionSelector()

    class ShowInvalidInputDialog: RegistrationActionSelector(){
        companion object{
            const val MESSAGE = "Invalid input!"
        }
    }

    class ShowExistingEmailDialog: RegistrationActionSelector(){
        companion object{
            const val MESSAGE = "This account already register!"
        }
    }
}
