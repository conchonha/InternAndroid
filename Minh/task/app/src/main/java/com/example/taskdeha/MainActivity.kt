package com.example.taskdeha


import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.taskdeha.databinding.ActivityMainBinding
import com.example.taskdeha.utils.DialogUtils
import com.example.taskdeha.utils.DialogUtils.inProgress
import com.example.taskdeha.utils.LocaleManager
import com.example.taskdeha.utils.MySharedPreferences
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val listenerInterNetChange by lazy { CustomLifecycle() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        MySharedPreferences.init(this)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        if (isFirstLaunch()) {
            navController.navigate(R.id.fragmentLanguage)
        } else {
            navController.navigate(R.id.fragmentOnboarding)
        }
        DialogUtils.isLoadingDialog.observe(this) { isLoading ->
            inProgress(this, isLoading)
        }

        lifecycle.addObserver(listenerInterNetChange)
    }

    fun addInternetChange(callback: IInternetChange) {
        listenerInterNetChange.addInternetChange(callback)
    }

    fun removeInternetChange(callback: IInternetChange) {
        listenerInterNetChange.removeInternetChange(callback)
    }

    private fun isFirstLaunch(): Boolean {
        return MySharedPreferences.getBoolean("firstLaunch", true)
    }

    override fun attachBaseContext(base: Context) {
        MySharedPreferences.init(base)
        val selectedLanguage = MySharedPreferences.getString("locale", "")

        if (selectedLanguage != null) {
            return super.attachBaseContext(LocaleManager.updateResources(base, selectedLanguage))
        }
        return super.attachBaseContext(base)
    }
}