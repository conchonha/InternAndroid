package com.example.taskdeha

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.wifi.WifiManager
import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.example.taskdeha.app.MyApplication

interface IInternetChange{
    fun onInternetChange(isNetWork: Boolean)
}

class CustomLifecycle : DefaultLifecycleObserver {
    val internetChangeCallbacks = java.util.HashSet<IInternetChange>()
    var activity: MainActivity? = null

    private val netWorkChange by lazy {
        object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                internetChangeCallbacks.forEach {
                    val isInterNet: Boolean = checkInternet()
                    it.onInternetChange(isInterNet)
                }
            }
        }
    }

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        activity = owner as? MainActivity
    }

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        IntentFilter().apply {
            addAction(ConnectivityManager.CONNECTIVITY_ACTION)
//            addAction(WifiManager.WIFI_STATE_CHANGED_ACTION)
//            addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION)
//            addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
            activity?.registerReceiver(
                netWorkChange,
                this
            )
        }
        Log.d("internetChangeCallbacks", internetChangeCallbacks.toString())
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        activity?.unregisterReceiver(netWorkChange)
        Log.d("Observer", "LifecycleOwner in onStop")

    }

    private fun checkInternet(): Boolean {
        val connectivityManager = MyApplication.application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork
        val networkCapabilities = connectivityManager.getNetworkCapabilities(network)
        return networkCapabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            ?: false
    }

    //0x1cc
    fun addInternetChange(iInternetChange: IInternetChange) {
        internetChangeCallbacks.add(iInternetChange)
    }

    //0x1cc
    fun removeInternetChange(iInternetChange: IInternetChange) {
        internetChangeCallbacks.remove(iInternetChange)
    }
}