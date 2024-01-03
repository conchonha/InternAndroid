package com.example.taskdeha.utils

import android.app.AlertDialog
import android.content.Context
import android.app.Dialog
import android.util.Log
import android.widget.Toast
import com.example.taskdeha.R

object DialogUtils {
    @Volatile
    var countApi = 0

    @Volatile
    var dialog: Dialog? = null

    @Volatile
    var alert: AlertDialog? = null

    val isLoadingDialog = SingleLiveEvent<Boolean>()

    fun showLoadingDialog(context: Context) {
        if (countApi == 0) {
            dialog = Dialog(context, R.style.CustomAlertDialogTheme).apply {
                setContentView(R.layout.loading)
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
                .setTitle(R.string.error)
                .setMessage(message)
                .setCancelable(false)
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

    fun dimissAlert() {
        alert?.dismiss()
        alert = null
    }

    fun inProgress(context: Context, isLoading: Boolean) {
        if (isLoading) {
            showLoadingDialog(context)
        } else {
            dismissLoadingDialog()
        }
    }

    fun showToast(res: String, context: Context) {
        Toast.makeText(context, res, Toast.LENGTH_SHORT).show()
    }
}