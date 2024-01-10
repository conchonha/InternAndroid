package com.example.learnnavigation.ui.viewmodel

import android.annotation.SuppressLint
import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class IntroduceViewModel(application: Application) : BaseViewModel(application) {

    private val _navigateToHostFragment = MutableLiveData<Boolean>()
    val navigateToHostFragment: LiveData<Boolean> get() = _navigateToHostFragment

    fun onSkipClicked() {
        _navigateToHostFragment.value = true
    }

    fun onContinueClicked(currentItem: Int, itemCount: Int) {
        var updateCurrentItem = currentItem
        if (updateCurrentItem == itemCount - 1) {
            _navigateToHostFragment.value = true
        } else {
            updateCurrentItem += 1
        }
    }

}