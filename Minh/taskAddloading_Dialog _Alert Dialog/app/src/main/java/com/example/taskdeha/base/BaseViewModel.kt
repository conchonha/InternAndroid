package com.example.taskdeha.base

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskdeha.extension.traceErrorException
import com.example.taskdeha.utils.DialogUtils.dismissLoadingDialog
import com.example.taskdeha.utils.DialogUtils.isLoadingDialog
import com.example.taskdeha.utils.DialogUtils.showErrorDialog
import com.example.taskdeha.utils.DialogUtils.showLoadingDialog
import com.example.taskdeha.utils.SingleLiveEvent
import kotlinx.coroutines.launch
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response

open class BaseViewModel : ViewModel() {
    val message = SingleLiveEvent<String>()

    fun <T : Any> Call<T>.enqueue(liveData: MutableLiveData<T>) {
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
