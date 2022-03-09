package com.example.cars.ext

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.cars.registration.presentation.dialog.LoginDialog

fun FragmentActivity.openFragment(fragment: Fragment, tag: String, id: Int) {
    supportFragmentManager
        .beginTransaction()
        .add(id, fragment, tag)
        .addToBackStack(tag)
        .commit()
}
fun FragmentActivity.dialog() {
    val myDialogFragment = LoginDialog()
    val manager = supportFragmentManager
    myDialogFragment.show(manager, "myDialog")
}