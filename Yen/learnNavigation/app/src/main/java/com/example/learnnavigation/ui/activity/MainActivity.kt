package com.example.learnnavigation.ui.activity

import android.content.Context
import android.os.Bundle
import android.view.Menu
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.learnnavigation.R
import com.example.learnnavigation.databinding.ActivityMainBinding
import com.example.learnnavigation.ui.CustomLifecycle
import com.example.learnnavigation.ui.IInternetChange
import com.example.learnnavigation.ui.viewmodel.IActionMainActivity
import com.example.learnnavigation.ui.viewmodel.ShareViewModel
import com.example.learnnavigation.utils.DialogUtils.inProgress
import com.example.learnnavigation.utils.DialogUtils.isLoadingDialog
import com.example.learnnavigation.utils.LocaleManager
import com.example.learnnavigation.utils.SharePrefs

class MainActivity : AppCompatActivity(), IActionMainActivity {
    private val shareViewModel by viewModels<ShareViewModel>()
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private val listenerInterNetChange by lazy { CustomLifecycle() }

    override fun attachBaseContext(newBase: Context) {
        val selectedLanguage = SharePrefs.getStringData(newBase, "selected_language")
        if (selectedLanguage != null){
            return super.attachBaseContext(LocaleManager.updateResources(newBase,selectedLanguage))
        }
        return super.attachBaseContext(newBase)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        lifecycle.addObserver(listenerInterNetChange)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        isLoadingDialog.observe(this){isLoading->
            inProgress(this,isLoading)
        }
//        shareViewModel.shareFlow.onEach {
//           handleEventToolBar(it)
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

    override fun navigation(id: Int, bundle: Bundle?) {}

    override fun restartApp() {
        recreate()
    }
}

