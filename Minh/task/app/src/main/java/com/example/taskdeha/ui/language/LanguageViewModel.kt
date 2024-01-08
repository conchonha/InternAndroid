package com.example.taskdeha.ui.language

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.example.taskdeha.R
import com.example.taskdeha.base.BaseViewModel
import com.example.taskdeha.data.model.Language
import com.example.taskdeha.ui.adapter.OnItemClickListener
import com.example.taskdeha.utils.DialogUtils
import com.example.taskdeha.utils.MySharedPreferences

class LanguageViewModel(application: Application) : BaseViewModel(application),
    OnItemClickListener<Language> {
    private var language = Language()

    init {
        if (isFirstLaunch()) {
            navController.navigate(R.id.fragmentLanguage)
        } else {
            navController.navigate(R.id.fragmentOnboarding)
        }
    }

    fun changeLanguage() {
        if (language.nameLanguage != null) {
            language.locale?.let { languageLocale ->
                getString(languageLocale)?.let {locale->
                    MySharedPreferences.putString("locale", locale)
                }
            }
            setFirstLaunch(false)
            iActivityAction?.navigation(R.id.action_fragmentLanguage_to_fragmentOnboarding,null)
        } else {
           DialogUtils.showToast("sd",getApplication())
        }
    }

    private fun setFirstLaunch(isFirstTime: Boolean) {
        MySharedPreferences.putBoolean("firstLaunch", isFirstTime)
    }

    override fun onItemClick(position: Int, data: Language) {
        language = data
    }
}