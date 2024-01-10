package com.example.learnnavigation.ui.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.learnnavigation.data.model.Drink
import com.example.learnnavigation.data.remote.ApiService

class AnimImageViewModel(application: Application) : BaseViewModel(application) {

    val drinks = MutableLiveData<Drink>()

    fun fetchDataFromApi() {
        val apiService = ApiService.getService_2()

        apiService.getDrinks().enqueues(drinks)
    }
}






