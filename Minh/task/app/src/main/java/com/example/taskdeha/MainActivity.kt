package com.example.taskdeha


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.taskdeha.databinding.ActivityMainBinding
import com.example.taskdeha.utils.DialogUtils
import com.example.taskdeha.utils.DialogUtils.inProgress
import com.example.taskdeha.utils.MySharedPreferences


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val listenerInterNetChange by lazy { CustomLifecycle() }
//    private lateinit var networkObserver: NetworkReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        lifecycle.addObserver(OpenCameraUSb())

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        MySharedPreferences.init(this)
//
//        if (isFirstLaunch()) {
//
//            setFirstLaunch(false)
//        } else {
//            val navHostFragment =
//                supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
//            navHostFragment.navController
//
//        }
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navHostFragment.navController
        DialogUtils.isLoadingDialog.observe(this) { isLoading ->
            inProgress(this, isLoading)
        }


//        networkObserver = NetworkReceiver(this)
//        lifecycle.addObserver(networkObserver)
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

    private fun setFirstLaunch(isFirstTime: Boolean) {
        MySharedPreferences.putBoolean("firstLaunch", isFirstTime)
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