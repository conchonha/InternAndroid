package com.example.learnnavigation.ui.viewmodel

import android.annotation.SuppressLint
import android.app.Application
import android.os.Bundle
import androidx.lifecycle.viewModelScope
import com.example.learnnavigation.R
import com.example.learnnavigation.data.model.languageCountry
import com.example.learnnavigation.ui.adapter.CallBackVoid
import com.example.learnnavigation.ui.adapter.IActionClick
import com.example.learnnavigation.utils.DialogUtils
import com.example.learnnavigation.utils.LocaleManager
import com.example.learnnavigation.utils.SharePrefs
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ChangedLanguageViewModel(application: Application) : BaseViewModel(application),
    IActionClick {


    @SuppressLint("StaticFieldLeak")
    private val context = getApplication<Application>().applicationContext

    private var isCheckLanguage = SharePrefs.getBooleanData(context, "isLanguage")
    private fun checkFragment(){
        if(isCheckLanguage){
            navigation(R.id.fragmentHost)
        }
    }

    override fun onInit(arg: Bundle?) {
        checkFragment()
    }
    override fun onClickItem(position: Int, data: languageCountry, callback: CallBackVoid) {
        data.isChecked = true
        callback?.invoke()
        getString(data.locate)
        SharePrefs.setStringData(context, "selected_language", getString(data.locate))
    }
    fun changeLanguage() {
        if (!isCheckLanguage) {
            navigation(R.id.fragmentIntroduction)
            SharePrefs.setBooleanData(context, "isLanguage", true)
            iActivityAction?.restartApp()
        } else {
            DialogUtils.showToast("abc",getApplication())
        }
    }
}