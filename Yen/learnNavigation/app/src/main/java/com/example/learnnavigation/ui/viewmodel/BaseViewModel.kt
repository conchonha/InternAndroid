package com.example.learnnavigation.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.learnnavigation.extension.traceErrorException
import com.example.learnnavigation.utils.DialogUtils.isLoadingDialog
import com.example.learnnavigation.utils.SingleLiveEvent
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response

open class BaseViewModel : ViewModel() {
    val message = SingleLiveEvent<String>()
    fun <T : Any> Call<T>.enqueues(liveData: MutableLiveData<T>) {
        isLoadingDialog.postValue(true)
        enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                isLoadingDialog.postValue(false)

                if (response.isSuccessful) {
                    liveData.postValue(response.body() as T)
                } else {
                    try {
                        response.errorBody()?.charStream()?.readText().run {
                            if (!this.isNullOrBlank()) {
                                val errorMessage = JSONObject(this).getString("message")
                                if (!errorMessage.isNullOrBlank()) {
                                    message.postValue(errorMessage)
                                    return
                                }
                            }
                        }
                    } catch (e: Exception) {
                        message.postValue(traceErrorException(HttpException(response)))
                        Log.d("errorException", e.toString())
                    }
                }
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                isLoadingDialog.postValue(false)
                message.postValue(traceErrorException(t))
                Log.d("errorCall", message.toString())
            }
        })
    }
}