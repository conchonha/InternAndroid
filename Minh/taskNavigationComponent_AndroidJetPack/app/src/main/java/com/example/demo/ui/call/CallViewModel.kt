package com.example.demo.ui.call

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demo.data.model.SuggestedSearches
import com.example.demo.data.repository.MetaDataReposirotyImpl
import com.example.demo.data.repository.MetaDataRepository
import com.example.demo.datasource.remote.RemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CallViewModel : ViewModel() {
    private var _data=MutableLiveData<List<SuggestedSearches>>()
    val data:LiveData<List<SuggestedSearches>> get() = _data
    private val dataRepository:MetaDataRepository=MetaDataReposirotyImpl(RemoteDataSource())

    fun getData(){
        viewModelScope.launch (Dispatchers.IO){
            val response=dataRepository.getData()
            if(response.isSuccessful){
                _data.postValue(response.body()?.suggestedSearches)
            }else{
                Log.d("GETDATA", "NULL")
            }
        }
    }
}