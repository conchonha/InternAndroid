package com.example.learnnavigation.ui.viewmodel

import android.content.Context
import com.example.learnnavigation.data.remote.ApiService
import com.example.learnnavigation.data.model.Drinks
import com.example.learnnavigation.utils.SingleLiveEvent

class RingViewModel : BaseViewModel() {

    val drinks = SingleLiveEvent<List<Drinks>>()

    fun fetchDataFromApi(context: Context) {
        val apiService = ApiService.getService_2()

        apiService.getGin().observe(context) {
            this@RingViewModel.drinks.postValue(drinks)
        }
    }
}




