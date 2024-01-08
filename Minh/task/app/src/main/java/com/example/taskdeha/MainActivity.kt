package com.example.taskdeha


import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.taskdeha.base.IActionMainActivity
import com.example.taskdeha.databinding.ActivityMainBinding
import com.example.taskdeha.utils.DialogUtils
import com.example.taskdeha.utils.DialogUtils.inProgress
import com.example.taskdeha.utils.LocaleManager
import com.example.taskdeha.utils.MySharedPreferences
import java.util.*


class MainActivity : AppCompatActivity(), IActionMainActivity {
    private lateinit var binding: ActivityMainBinding
    private val listenerInterNetChange by lazy { CustomLifecycle() }
    private var controller: NavController? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        controller = navHostFragment.navController

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
        val selectedLanguage = MySharedPreferences.getString("locale", "")

        if (selectedLanguage != null) {
            return super.attachBaseContext(LocaleManager.updateResources(base, selectedLanguage))
        }
        return super.attachBaseContext(base)
    }

    override fun navigation(id: Int, bundle: Bundle?) {
        controller?.navigate(id,bundle)
    }
}