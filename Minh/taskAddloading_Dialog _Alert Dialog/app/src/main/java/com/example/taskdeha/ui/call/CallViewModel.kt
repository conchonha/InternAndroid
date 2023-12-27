package com.example.taskdeha.ui.call

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.taskdeha.base.BaseViewModel
import com.example.taskdeha.data.model.MetaData
import com.example.taskdeha.data.model.SuggestedSearches
import com.example.taskdeha.data.repository.MetaDataReposirotyImpl
import com.example.taskdeha.data.repository.MetaDataRepository
import com.example.taskdeha.datasource.remote.RemoteDataSource

class CallViewModel : BaseViewModel() {
    private var _data = MutableLiveData<List<SuggestedSearches>>()
    val data: LiveData<List<SuggestedSearches>> = _data
    private val dataRepository: MetaDataRepository = MetaDataReposirotyImpl(RemoteDataSource())

    val metaData = MutableLiveData<MetaData>()

    fun getData() {
        dataRepository.getData().enqueue(metaData)
    }
}

