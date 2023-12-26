package com.example.taskdeha.datasource.remote

import com.example.taskdeha.data.model.MetaData
import com.example.taskdeha.data.api.RetrofitClient
import com.example.taskdeha.datasource.IDataSource
import retrofit2.Call

import retrofit2.Response

class RemoteDataSource() : IDataSource {
    override fun getData(): Call<MetaData>{
        return RetrofitClient.apiService.getData()
    }

}