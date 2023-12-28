package com.example.learnnavigation.ui.activity

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.learnnavigation.R
import com.example.learnnavigation.databinding.ActivityMainBinding
import com.example.learnnavigation.ui.CallBackResult
import com.example.learnnavigation.ui.CustomLifecycle
import com.example.learnnavigation.ui.dialog.DialogUtils.dismissLoadingDialog
import com.example.learnnavigation.ui.dialog.DialogUtils.inProgress
import com.example.learnnavigation.ui.dialog.DialogUtils.isLoadingDialog
import com.example.learnnavigation.ui.dialog.DialogUtils.showErrorDialog

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

    fun registerInternetChange(fragment: Fragment) {
        val networkChange = object : CallBackResult {
            override fun invoke(isConnected: Boolean) {
                if (!isConnected) {
                    showErrorDialog(fragment.requireContext(), "Kết nối mạng mau")
                } else {
                    dismissLoadingDialog()
                }
            }
        }
        addInternetChange(networkChange)
    }
    fun unregisterInternetChange() {
        val networkChange = object : CallBackResult {
            override fun invoke(isConnected: Boolean) {
                if (!isConnected) {
                    dismissLoadingDialog()
                }
            }
        }
        removeInternetChange(networkChange)
    }
    fun addInternetChange(callback: CallBackResult) {
        listenerInterNetChange.addInternetChange(callback)
    }
    fun removeInternetChange(callback: CallBackResult) {
        listenerInterNetChange.removeInternetChange(callback)
    }
}

