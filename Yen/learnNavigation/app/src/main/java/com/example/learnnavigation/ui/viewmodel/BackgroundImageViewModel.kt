package com.example.learnnavigation.ui.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.learnnavigation.data.model.Demo
import com.example.learnnavigation.data.model.languageCountry
import com.example.learnnavigation.data.remote.ApiService
import com.example.learnnavigation.ui.adapter.CallBackVoid
import com.example.learnnavigation.ui.adapter.IActionClick

class BackgroundImageViewModel(application: Application) : BaseViewModel(application){


    val suggestedSearches = MutableLiveData<Demo>()

    fun fetchDataFromApi() {
        val apiService = ApiService.getService()

        apiService.getDictionaries().enqueues(suggestedSearches)
        }



}




