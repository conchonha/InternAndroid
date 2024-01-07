package com.example.taskdeha.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.taskdeha.app.MyApplication

object MySharedPreferences {
    private const val sharedPreferencesName = "myPreference"
    private val  sharedPreferences: SharedPreferences = getShaprefs()
    private fun getShaprefs() =
        MyApplication.application.getSharedPreferences(sharedPreferencesName, Context.MODE_PRIVATE)


    fun putString(key: String, value: String) {
        val editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getString(key: String, defaultValue: String): String {
        return sharedPreferences.getString(key, defaultValue) ?: defaultValue
    }

    fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        return sharedPreferences.getBoolean(key, defaultValue)
    }

    fun putBoolean(key: String, value: Boolean) {
        val editor = sharedPreferences.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }
}