package com.example.learnnavigation.ui.viewmodel

import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learnnavigation.extension.traceErrorException
import com.example.learnnavigation.utils.DialogUtils.isLoadingDialog
import com.example.learnnavigation.utils.EventSender
import com.example.learnnavigation.utils.SharePrefs
import com.example.learnnavigation.utils.SingleLiveEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response

abstract class BaseViewModel(application: Application) : AndroidViewModel(application) {
    val message = SingleLiveEvent<String>()
    var isResume: Boolean = false

    private val event = Channel<EventSender>()
    val eventReceiver = event.receiveAsFlow().conflate()

    var iActivityAction: IActionMainActivity? = null

    open fun onInit(arg: Bundle?){}
    fun navigation(des: Int, bundle: Bundle? = null) {
        viewModelScope.launch {
            event.send(EventSender.Navigation(des, bundle))
        }
    }
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

    fun getString(res: Int) = getApplication<Application>().getString(res)
}

interface IActionMainActivity{
    fun navigation(id: Int,bundle: Bundle?)
    fun restartApp()
}