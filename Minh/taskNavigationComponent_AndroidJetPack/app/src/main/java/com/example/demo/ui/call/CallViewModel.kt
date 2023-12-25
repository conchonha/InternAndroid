package com.example.demo.ui.call

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demo.data.api.RetrofitClient
import com.example.demo.data.model.SuggestedSearches
import com.example.demo.data.repository.MetaDataReposirotyImpl
import com.example.demo.data.repository.MetaDataRepository
import com.example.demo.datasource.remote.RemoteDataSource
import com.example.demo.extension.traceErrorException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException

class CallViewModel : ViewModel() {
    private var _data = MutableLiveData<List<SuggestedSearches>>()
    val data: LiveData<List<SuggestedSearches>> = _data
    val message = MutableLiveData<String>()
    private val dataRepository: MetaDataRepository = MetaDataReposirotyImpl(RemoteDataSource())

    //    fun getData() {
//        viewModelScope.launch (Dispatchers.IO){
//            val response=dataRepository.getData()
//            if (response.isSuccessful) {
//                _data.postValue(response.body()?.suggestedSearches)
//            } else{
//                Log.d("GETDATA", "NULL")
//            }
//        }
//    }
    fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = dataRepository.getData()

                if (response.isSuccessful) {
                    _data.postValue(response.body()?.suggestedSearches)
                } else {
                    val apiError = traceErrorException(HttpException(response))
                    message.postValue(apiError)
                }
            } catch (e: Throwable) {
                val apiError = traceErrorException(e)
                message.postValue(apiError)
            }
        }
    }

}
