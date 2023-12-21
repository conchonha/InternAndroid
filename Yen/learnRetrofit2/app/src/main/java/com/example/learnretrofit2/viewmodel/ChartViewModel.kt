package com.example.learnretrofit2.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.learnretrofit2.data.api.ApiService
import com.example.learnretrofit2.model.Chart
import com.example.learnretrofit2.model.SuggestedSearches
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChartViewModel : ViewModel() {

    private val _suggestedSearches = MutableLiveData<List<SuggestedSearches>>()
    val suggestedSearches: LiveData<List<SuggestedSearches>> = _suggestedSearches

    fun fetchDataFromApi() {
        val apiService = ApiService.getService()

        apiService.getDictionaries().enqueue(object : Callback<Chart> {
            override fun onResponse(call: Call<Chart>, response: Response<Chart>) {
                if (response.isSuccessful) {
                    val suggestedSearches = response.body()?.suggested_searches ?: emptyList()
                    _suggestedSearches.value = suggestedSearches
                }
            }

            override fun onFailure(call: Call<Chart>, t: Throwable) {
                Log.d("errorCall", t.toString())
            }
        })
    }
}