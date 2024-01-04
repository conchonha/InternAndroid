package com.example.learnnavigation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class ShareViewModel : ViewModel(){
    val shareFlow =  MutableSharedFlow<EventToolbar>()

    fun chanEvent(event: EventToolbar){
        viewModelScope.launch {
            shareFlow.emit(event)
        }
    }
}

sealed class EventToolbar{
    data object OpenSearch: EventToolbar()
}