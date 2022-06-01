package com.example.cars.registration.presentation.utils

import android.content.Context
import javax.inject.Inject

class SharedPreferencesManagerImpl @Inject constructor(context: Context) : SharedPreferencesManager {
    companion object {
        private const val PREFS_NAME = "login_prefs"
        private const val BOOLEAN_DEFAULT_VALUE = false
    }

    private val prefs by lazy { context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE) }

    override fun save(key: String, value: Boolean) {
        prefs.edit()
            .putBoolean(key, value)
            .apply()
    }

    override fun get(key: String): Boolean {
        return prefs.getBoolean(key, BOOLEAN_DEFAULT_VALUE)
    }
}