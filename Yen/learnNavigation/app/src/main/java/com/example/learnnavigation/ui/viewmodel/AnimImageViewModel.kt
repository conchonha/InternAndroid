package com.example.learnnavigation.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.learnnavigation.data.model.Drink
import com.example.learnnavigation.data.remote.ApiService

class AnimImageViewModel : BaseViewModel() {

    val drinks = MutableLiveData<Drink>()

    fun fetchDataFromApi() {
        val apiService = ApiService.getService_2()

        apiService.getDrinks().enqueues(drinks)
    }
}






