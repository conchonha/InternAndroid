package com.example.learnnavigation.utils

import androidx.annotation.DimenRes
import androidx.annotation.StringRes
import com.example.learnnavigation.app.MyApplication

fun getResouce() = MyApplication.application.resources
fun getString(@StringRes res: Int) = getResouce().getString(res)

fun getDimens(@DimenRes dimen: Int) = getResouce().getDimension(dimen)