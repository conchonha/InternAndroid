package com.example.learnnavigation.ui.viewmodel


import android.content.Context
import com.example.learnnavigation.data.remote.ApiService
import com.example.learnnavigation.data.model.SuggestedSearches
import com.example.learnnavigation.utils.SingleLiveEvent

class BackgroundImageViewModel : BaseViewModel() {

    val suggestedSearches = SingleLiveEvent<List<SuggestedSearches>>()

    fun fetchDataFromApi(context: Context) {
        val apiService = ApiService.getService()

        apiService.getDictionaries().observe(context) {
            this@BackgroundImageViewModel.suggestedSearches.postValue(suggestedSearches)
        }
    }
}



