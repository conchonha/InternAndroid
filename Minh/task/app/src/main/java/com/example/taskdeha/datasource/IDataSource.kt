package com.example.taskdeha.datasource

import com.example.taskdeha.data.model.Drinks
import com.example.taskdeha.data.model.MetaData
import com.example.taskdeha.data.model.url2.Product
import com.example.taskdeha.data.model.url2.Products
import retrofit2.Call

interface IDataSource {
    fun getData(): Call<MetaData>
    fun getDataDrink(): Call<Drinks>
    fun getProduct(): Call<Products>
}