package com.example.taskdeha


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.taskdeha.databinding.ActivityMainBinding
import com.example.taskdeha.utils.DialogUtils
import com.example.taskdeha.utils.DialogUtils.inProgress
import com.example.taskdeha.utils.MySharedPreferences


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val listenerInterNetChange by lazy { CustomLifecycle() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        MySharedPreferences.init(this)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        if (isFirstLaunch()) {
            navController.navigate(R.id.fragmentLanguage)

        } else {
            navController.navigate(R.id.fragmentMenu)
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
}