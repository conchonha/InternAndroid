package com.example.learnnavigation.utils

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import com.example.learnnavigation.R

object DialogUtils {
    @Volatile
    var countApi = 0

    @Volatile
    var dialog: Dialog? = null

    @Volatile
    var alert: AlertDialog? = null

     val isLoadingDialog = SingleLiveEvent<Boolean>()
   //  fun changeStateLoading(isLoading: Boolean){}
    fun showLoadingDialog(context: Context) {
        if (countApi == 0) {
            dialog = Dialog(context).apply {
                setContentView(R.layout.dialog_loading)
                window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                setCancelable(false)
            }
            dialog?.show()
        }
        countApi++
        Log.d("LoadingDialog", "showLoadingDialog: $countApi")
    }

    fun showErrorDialog(context: Context, message: String) {
        if (alert == null) {
            alert = AlertDialog.Builder(context)
                .setTitle(R.string.error_title)
                .setMessage(message)
                .setPositiveButton(android.R.string.ok) { _, _ ->
                    countApi = 0
                    alert = null
                }
                .create()
            alert?.show()
        }
    }

    fun dismissLoadingDialog() {
        countApi--
        if (countApi <= 0) {
            countApi = 0
            dialog?.dismiss()
        }
    }
//    fun dismissLoadingDialog(dialog: Dialog?) {
//        dialog?.let {
//            if (it.isShowing) {
//                it.dismiss()
//            }
//        }
//    }
     fun inProgress(context: Context,isLoading: Boolean){
         if (isLoading){
             showLoadingDialog(context)
         }else{
             dismissLoadingDialog()
         }
     }
}