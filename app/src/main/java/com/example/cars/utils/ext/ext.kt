package com.example.cars.utils.ext

import android.content.Context
import android.util.Patterns
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.cars.CarApplication
import com.example.cars.di.AppComponent
import com.example.cars.registration.presentation.dialog.LoginDialog

fun FragmentActivity.openFragment(fragment: Fragment, tag: String, id: Int) {
    supportFragmentManager
        .beginTransaction()
        .add(id, fragment, tag)
        .addToBackStack(tag)
        .commit()
}

val Context.appComponent: AppComponent
    get() = when(this){
        is CarApplication -> appComponent
        else -> this.applicationContext.appComponent
    }

fun FragmentActivity.dialog() {
    val myDialogFragment = LoginDialog()
    val manager = supportFragmentManager
    myDialogFragment.show(manager, "myDialog")
}

fun String.isEmail(): Boolean{
    return Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

