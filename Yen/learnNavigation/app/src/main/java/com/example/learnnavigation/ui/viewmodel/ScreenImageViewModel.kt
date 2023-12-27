package com.example.learnnavigation.ui.viewmodel


import android.content.Context
import com.example.learnnavigation.data.remote.ApiService
import com.example.learnnavigation.data.model.Drinks
import com.example.learnnavigation.utils.SingleLiveEvent

class ScreenImageViewModel : BaseViewModel() {

    val drinks = SingleLiveEvent<List<Drinks>>()

    fun fetchDataFromApi(context: Context) {
        val apiService = ApiService.getService_2()

        apiService.getVodka().observe(context) {
            this@ScreenImageViewModel.drinks.postValue(drinks)
        }
    }
}




