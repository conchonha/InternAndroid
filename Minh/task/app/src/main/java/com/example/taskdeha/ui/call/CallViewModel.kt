package com.example.taskdeha.ui.call

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.taskdeha.base.BaseViewModel
import com.example.taskdeha.data.model.MetaData
import com.example.taskdeha.data.model.SuggestedSearches
import com.example.taskdeha.data.model.url2.Products
import com.example.taskdeha.data.repository.meta.MetaDataReposirotyImpl
import com.example.taskdeha.data.repository.meta.MetaDataRepository
import com.example.taskdeha.data.repository.product.ProductRepository
import com.example.taskdeha.data.repository.product.ProductRepositoryImpl
import com.example.taskdeha.datasource.remote.RemoteDataSource

class CallViewModel : BaseViewModel() {
    private var _data = MutableLiveData<List<SuggestedSearches>>()
    val data: LiveData<List<SuggestedSearches>> = _data
    private val dataRepository: MetaDataRepository = MetaDataReposirotyImpl(RemoteDataSource())
    private val productRepository: ProductRepository = ProductRepositoryImpl(RemoteDataSource())

    val metaData = MutableLiveData<MetaData>()

    fun getData() {
        dataRepository.getData().enqueue(metaData)
    }
    val product = MutableLiveData<Products>()
    fun getProduct() {
        productRepository.getProduct().enqueue(product)
    }
}

