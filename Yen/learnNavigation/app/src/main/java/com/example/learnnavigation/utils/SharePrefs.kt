package com.example.learnnavigation.utils

import android.content.Context
import android.content.SharedPreferences


object SharePrefs {
    private const val PREFS_FILE_NAME = "localData"
    fun getStringData(ctx: Context, key: String?): String? {
        return ctx.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE).getString(key, "")
    }

    fun setStringData(ctx: Context, key: String?, data: String?) {
        val prefs = ctx.getSharedPreferences(
            PREFS_FILE_NAME, Context.MODE_PRIVATE
        )
        val editor: SharedPreferences.Editor = prefs.edit()
        editor.putString(key, data)
        editor.apply()
    }

    fun getBooleanData(ctx: Context, key: String?): Boolean {
        return ctx.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE)
            .getBoolean(key, false)
    }

    fun setBooleanData(ctx: Context, key: String?, data: Boolean?) {
        val prefs = ctx.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE)

        val editor: SharedPreferences.Editor = prefs.edit()
        editor.putBoolean(key, data!!)
        editor.apply()
    }
}