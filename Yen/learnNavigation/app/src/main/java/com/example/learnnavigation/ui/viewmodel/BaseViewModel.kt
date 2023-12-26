package com.example.learnnavigation.ui.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.learnnavigation.extension.traceErrorException
import com.example.learnnavigation.ui.dialog.DialogUtils.dismissLoadingDialog
import com.example.learnnavigation.ui.dialog.DialogUtils.showErrorDialog
import com.example.learnnavigation.ui.dialog.DialogUtils.showLoadingDialog
import com.example.learnnavigation.utils.SingleLiveEvent
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response

open class BaseViewModel : ViewModel() {
    val message = SingleLiveEvent<String>()

    fun <T : Any> Call<T>.observe(context: Context, result: T.() -> Unit) {
        showLoadingDialog(context)

        enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                dismissLoadingDialog()

                if (response.isSuccessful) {
                    result.invoke(response.body() as T)
                } else {
                    try {
                        response.errorBody()?.charStream()?.readText().run {
                            if (!this.isNullOrBlank()) {
                                val errorMessage = JSONObject(this).getString("message")
                                if (!errorMessage.isNullOrBlank()) {
                                    showErrorDialog(context, errorMessage)
                                    return
                                }
                            }
                        }
                    } catch (e: Exception) {
                        showErrorDialog(context,
                            message.postValue(traceErrorException(HttpException(response)))
                                .toString()
                        )

                    }
                }
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                dismissLoadingDialog()
                showErrorDialog(context, message.postValue(traceErrorException(t)).toString())
                Log.d("errorCall", t.toString())
            }
        })
    }
}