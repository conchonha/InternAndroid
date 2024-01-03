package com.example.taskdeha.datasource.remote

import com.example.taskdeha.data.model.MetaData
import com.example.taskdeha.data.api.RetrofitClient
import com.example.taskdeha.data.model.Drinks
import com.example.taskdeha.data.model.url2.Products
import com.example.taskdeha.datasource.IDataSource
import retrofit2.Call

class RemoteDataSource() : IDataSource {
    override fun getData(): Call<MetaData>{
        return RetrofitClient.apiService.getData()
    }

    override fun getDataDrink(): Call<Drinks> {
        return RetrofitClient.apiService2.getDrinks()
    }

    override fun getProduct(): Call<Products> {
        return RetrofitClient.apiService3.getHotBook()
    }
}