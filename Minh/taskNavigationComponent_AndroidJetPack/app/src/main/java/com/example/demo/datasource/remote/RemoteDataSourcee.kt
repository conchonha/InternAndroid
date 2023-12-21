package com.example.demo.datasource.remote

import com.example.demo.data.api.RetrofitClient
import com.example.demo.data.model.MetaData
import com.example.demo.datasource.IDataSource

import retrofit2.Response

class RemoteDataSource() : IDataSource {

    override suspend fun getData(): Response<MetaData>{
        return RetrofitClient.apiService.getData()
    }

}