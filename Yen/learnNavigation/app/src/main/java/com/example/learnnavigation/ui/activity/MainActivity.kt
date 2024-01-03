package com.example.learnnavigation.ui.activity

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.learnnavigation.R
import com.example.learnnavigation.databinding.ActivityMainBinding
import com.example.learnnavigation.ui.CustomLifecycle
import com.example.learnnavigation.ui.IInternetChange
import com.example.learnnavigation.ui.fragment.FragmentChangeLanguage
import com.example.learnnavigation.ui.viewmodel.EventToolbar
import com.example.learnnavigation.ui.viewmodel.ShareViewModel
import com.example.learnnavigation.utils.DialogUtils.inProgress
import com.example.learnnavigation.utils.DialogUtils.isLoadingDialog
import com.example.learnnavigation.utils.LocaleHelper
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MainActivity : AppCompatActivity() {
    private val shareViewModel by viewModels<ShareViewModel>()
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private val listenerInterNetChange by lazy { CustomLifecycle() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        lifecycle.addObserver(listenerInterNetChange)
        selectLanguage()
        isLoadingDialog.observe(this){isLoading->
            inProgress(this,isLoading)
        }

//        shareViewModel.shareFlow.onEach {
//            when(it){
//                EventToolbar.OpenSearch ->
//            }
//        }.launchIn(lifecycleScope)
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }
    fun setToolbarTitle(title: String) {
        supportActionBar?.title = title
    }
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    fun addInternetChange(callback: IInternetChange) {
        listenerInterNetChange.addInternetChange(callback)
    }
    fun removeInternetChange(callback: IInternetChange) {
        listenerInterNetChange.removeInternetChange(callback)
    }

   private fun selectLanguage(){
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        val sharedPreferences = this.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val languageSelected = sharedPreferences.getBoolean("languageSelected", true)
        if (languageSelected) {
            navController.navigate(R.id.changeLanguageFragment)
            val editor = sharedPreferences.edit()
            editor.putBoolean("languageSelected", false)
            editor.apply()
        } else {
            navController.navigate(R.id.fragmentHost)
        }
        val selectedLanguage = sharedPreferences.getString("selectedLanguage", null)
        if (selectedLanguage != null) {
            when (selectedLanguage){
                "Japanese" -> {
                    LocaleHelper.setLocale(this, "ja")
                }
                "China" -> {
                    LocaleHelper.setLocale(this, "zh")
                }
                "France" -> {
                    LocaleHelper.setLocale(this, "fr")
                }
                "English" -> {
                    LocaleHelper.setLocale(this, "en")
                }
                "Spanish" -> {
                    LocaleHelper.setLocale(this, "se")
                }
                "Indian" -> {
                    LocaleHelper.setLocale(this, "hi")
                }
                "Korean" -> {
                    LocaleHelper.setLocale(this, "ko")
                }
            }
        }
    }
}

