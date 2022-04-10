package com.example.cars.utils.ext

import android.util.Patterns
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.cars.registration.presentation.dialog.ErrorEntryDialog

fun FragmentActivity.openFragment(fragment: Fragment, tag: String, id: Int) {
    supportFragmentManager
        .beginTransaction()
        .replace(id, fragment, tag)
        .addToBackStack(tag)
        .commit()
}

fun FragmentActivity.dialog(message: String) {
    val myDialogFragment = ErrorEntryDialog(message)
    val manager = supportFragmentManager
    myDialogFragment.show(manager, "myDialog")
}

fun String.isEmail(): Boolean{
    return Patterns.EMAIL_ADDRESS.matcher(this).matches()
}




