package com.example.cars.utils.ext

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.cars.app.presentation.MainActivity
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

fun <T> Context.openActivity(activity: Class<T>){
    val intent = Intent(this, activity)
    startActivity(intent)
}




