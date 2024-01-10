package com.example.taskdeha.utils

import android.content.res.Resources
import com.example.taskdeha.R
import com.example.taskdeha.data.model.Language

object Const {
    const val INDEX_0 = 0
    const val INDEX_1 = 1
    const val INDEX_2 = 2
    const val INDEX_3 = 3

    fun getListLanguage(resources: Resources): List<Language> {
        return listOf<Language>(
            Language(
                R.drawable.ic_flag_united_kingdom,
                resources.getString(R.string.language_english),
                R.string.const_eng
            ),
            Language(
                R.drawable.ic_flag_spain,
                resources.getString(R.string.language_spain),
                R.string.const_spain
            ),
            Language(
                R.drawable.ic_flag_portugal,
                resources.getString(R.string.language_portugal),
                R.string.const_portugal
            ),
            Language(
                R.drawable.ic_flag_india,
                resources.getString(R.string.language_hindi),
                R.string.const_india
            ),
            Language(
                R.drawable.ic_flag_germany,
                resources.getString(R.string.language_germany),
                R.string.const_germany
            ),
            Language(
                R.drawable.ic_flag_france,
                resources.getString(R.string.language_france),
                R.string.const_france
            ),
            Language(
                R.drawable.ic_flag_china,
                resources.getString(R.string.language_china),
                R.string.const_china
            )
        )
    }
}