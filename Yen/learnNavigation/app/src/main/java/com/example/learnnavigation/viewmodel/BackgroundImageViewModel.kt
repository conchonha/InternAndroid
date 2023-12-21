package com.example.learnnavigation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.learnnavigation.data.api.ApiService
import com.example.learnnavigation.model.Demo
import com.example.learnnavigation.model.SuggestedSearches
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BackgroundImageViewModel : ViewModel() {

    private val _suggestedSearches = MutableLiveData<List<SuggestedSearches>>()
    val suggestedSearches: LiveData<List<SuggestedSearches>> = _suggestedSearches

    fun fetchDataFromApi() {
        val apiService = ApiService.getService()

        apiService.getDictionaries().enqueue(object : Callback<Demo> {
            override fun onResponse(call: Call<Demo>, response: Response<Demo>) {
                if (response.isSuccessful) {
                    val suggestedSearches = response.body()?.suggested_searches ?: emptyList()
                    _suggestedSearches.value = suggestedSearches
                }
            }

            override fun onFailure(call: Call<Demo>, t: Throwable) {
                Log.d("errorCall", t.toString())
            }
        })
    }
}