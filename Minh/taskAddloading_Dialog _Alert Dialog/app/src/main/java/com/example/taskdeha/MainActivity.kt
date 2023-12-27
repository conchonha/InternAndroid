package com.example.taskdeha

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.fragment.NavHostFragment
import com.example.taskdeha.databinding.ActivityMainBinding
import com.example.taskdeha.utils.DialogUtils
import com.example.taskdeha.utils.DialogUtils.inProgress

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        lifecycle.addObserver(OpenCameraUSb())

        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        DialogUtils.isLoadingDialog.observe(this){
            if (it){
                DialogUtils.showLoadingDialog(this)
                return@observe
            }
            DialogUtils.dismissLoadingDialog()
        }
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navHostFragment.navController

        DialogUtils.isLoadingDialog.observe(this){isLoading->
            inProgress(this,isLoading)
        }

    }

}

//class OpenCameraUSb : DefaultLifecycleObserver{
//    override fun onCreate(owner: LifecycleOwner) {
//        super.onCreate(owner)
//        ( owner as? Activity)?.let {
//
//        }
//    }
//
//    override fun onStart(owner: LifecycleOwner) {
//        super.onStart(owner)
//    }
//
//    override fun onStop(owner: LifecycleOwner) {
//        super.onStop(owner)
//    }
//}