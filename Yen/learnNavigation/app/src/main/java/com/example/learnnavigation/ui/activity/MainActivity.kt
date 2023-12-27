package com.example.learnnavigation.ui.activity

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.learnnavigation.R
import com.example.learnnavigation.databinding.ActivityMainBinding
import com.example.learnnavigation.ui.dialog.DialogUtils

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        setSupportActionBar(binding.toolbar)

        DialogUtils.isLoadingDialog.observe(this){
            if (it){
                DialogUtils.showLoadingDialog(this)
                return@observe
            }
            DialogUtils.dismissLoadingDialog()
        }
        navController = navHostFragment.navController
        setupActionBarWithNavController(navController)
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
}

