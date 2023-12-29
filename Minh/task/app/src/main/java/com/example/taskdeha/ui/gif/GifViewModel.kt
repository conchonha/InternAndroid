package com.example.taskdeha.ui.gif

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.taskdeha.base.BaseViewModel
import com.example.taskdeha.data.model.Drinks
import com.example.taskdeha.data.model.MetaData
import com.example.taskdeha.data.model.SuggestedSearches
import com.example.taskdeha.data.repository.drink.DrinkRepository
import com.example.taskdeha.data.repository.drink.DrinkRepositoryImpl
import com.example.taskdeha.data.repository.meta.MetaDataReposirotyImpl
import com.example.taskdeha.data.repository.meta.MetaDataRepository
import com.example.taskdeha.datasource.remote.RemoteDataSource


class GifViewModel : BaseViewModel() {
    private var _data = MutableLiveData<List<SuggestedSearches>>()
    val data: LiveData<List<SuggestedSearches>> = _data
    private val drinkRepository: DrinkRepository = DrinkRepositoryImpl(RemoteDataSource())

    val dataDrink = MutableLiveData<Drinks>()

    fun getData() {
        drinkRepository.getDataDrink().enqueue(dataDrink)
    }

}