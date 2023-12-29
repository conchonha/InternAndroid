package com.example.learnnavigation.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.learnnavigation.data.model.Demo
import com.example.learnnavigation.data.remote.ApiService

class BackgroundImageViewModel : BaseViewModel() {


    val suggestedSearches = MutableLiveData<Demo>()

    fun fetchDataFromApi() {
        val apiService = ApiService.getService()

        apiService.getDictionaries().enqueues(suggestedSearches)
        }

}




