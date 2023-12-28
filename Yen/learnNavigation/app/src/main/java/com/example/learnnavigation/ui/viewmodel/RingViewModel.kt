package com.example.learnnavigation.ui.viewmodel

import com.example.learnnavigation.data.model.Drink
import com.example.learnnavigation.data.remote.ApiService
import com.example.learnnavigation.utils.SingleLiveEvent

class RingViewModel : BaseViewModel() {

    val drinks = SingleLiveEvent<Drink>()

    fun fetchDataFromApi() {
        val apiService = ApiService.getService_2()

        apiService.getGin().enqueues(drinks)
    }
}




