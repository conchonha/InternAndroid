//package com.example.taskdeha.service
//
//import android.content.BroadcastReceiver
//import android.content.Context
//import android.content.Intent
//import android.content.IntentFilter
//import android.net.ConnectivityManager
//import android.net.NetworkInfo
//import android.widget.Toast
//import androidx.lifecycle.*
//import com.example.taskdeha.utils.DialogUtils
//
//@Suppress("DEPRECATION")
//class NetworkReceiver(private val context: Context) : DefaultLifecycleObserver {
//
//    private val networkReceiver = object : BroadcastReceiver() {
//        override fun onReceive(context: Context, intent: Intent) {
//            handleNetworkChange()
//        }
//    }
//
//    override fun onStart(owner: LifecycleOwner) {
//        super.onStart(owner)
//        val intentFilter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
//        context.registerReceiver(networkReceiver, intentFilter)
//    }
//
//
//    override fun onStop(owner: LifecycleOwner) {
//        super.onStop(owner)
//        context.unregisterReceiver(networkReceiver)
//    }
//
//    private fun handleNetworkChange() {
//        val connectivityManager =
//            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//
//        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
//        val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true
//
//        if (isConnected) {
//            // Xử lý khi có kết nối mạng
//            DialogUtils.dimissAlert()
//            Toast.makeText(context, "Đã có kết nối mạng", Toast.LENGTH_SHORT).show()
//        } else {
//            // Xử lý khi mất kết nối mạng
//            DialogUtils.showErrorDialog(context, "Mat ke noi mang")
//            Toast.makeText(context, "Mất kết nối mạng", Toast.LENGTH_SHORT).show()
//        }
//    }
//}