package com.example.learnnavigation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.learnnavigation.data.api.ApiService
import com.example.learnnavigation.extension.traceErrorException
import com.example.learnnavigation.model.SuggestedSearches
import com.example.learnnavigation.utils.SingleLiveEvent
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response

class BackgroundImageViewModel : BaseViewModel() {

    val suggestedSearches = SingleLiveEvent<List<SuggestedSearches>>()

    fun fetchDataFromApi() {
        val apiService = ApiService.getService()

        apiService.getDictionaries().obsever {
            this@BackgroundImageViewModel.suggestedSearches.postValue(suggestedSearches)
        }
    }
}

open class BaseViewModel : ViewModel() {
    val loadingDialog = SingleLiveEvent<Boolean>()
    val message = SingleLiveEvent<String>()
    fun <T : Any> Call<T>.obsever(result: T.() -> Unit) {
        loadingDialog.postValue(true)
        enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                loadingDialog.postValue(false)
                if (response.isSuccessful) {
                    result.invoke(response.body() as T)
                } else {
                    try {
                        response.errorBody()?.charStream()?.readText().run {
                            if (!this.isNullOrBlank()) {
                                val message = JSONObject(this).getString("message")
                                if (message != null) {

                                    return
                                }
                            }
                        }
                    } catch (e: Exception) {
                        message.postValue(traceErrorException(HttpException(response)))
                    }
                }
            }
            override fun onFailure(call: Call<T>, t: Throwable) {
                Log.d("errorCall", t.toString())
                loadingDialog.postValue(false)
                message.postValue(traceErrorException(t))
            }
        })
    }
}



