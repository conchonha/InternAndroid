package com.example.learnnavigation.utils

import android.content.Context
import java.util.Locale

object LocaleHelper {
    private const val SELECTED_LANGUAGE = "Locale.Helper.Selected.Language"

    fun setLocale(context: Context, language: String?) {
        persist(context, language)
        updateResources(context, language)
    }

    private fun persist(context: Context, language: String?) {
        val preferences = context.getSharedPreferences(SELECTED_LANGUAGE, Context.MODE_PRIVATE)
        val editor = preferences.edit()
        editor.putString(SELECTED_LANGUAGE, language)
        editor.apply()
    }

    private fun updateResources(context: Context, language: String?) {
        val locale = language?.let { Locale(it) }
        if (locale != null) {
            Locale.setDefault(locale)
        }
        val resources = context.resources
        val configuration = resources.configuration
        configuration.locale = locale
        resources.updateConfiguration(configuration, resources.displayMetrics)
    }
}