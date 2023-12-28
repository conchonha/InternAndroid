package com.example.learnnavigation.ui.activity

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.learnnavigation.R
import com.example.learnnavigation.databinding.ActivityMainBinding
import com.example.learnnavigation.ui.CustomLifecycle
import com.example.learnnavigation.ui.IInternetChange
import com.example.learnnavigation.utils.DialogUtils.inProgress
import com.example.learnnavigation.utils.DialogUtils.isLoadingDialog

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private val listenerInterNetChange by lazy { CustomLifecycle() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        lifecycle.addObserver(listenerInterNetChange)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        setSupportActionBar(binding.toolbar)
        isLoadingDialog.observe(this){isLoading->
            inProgress(this,isLoading)
        }
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
}

