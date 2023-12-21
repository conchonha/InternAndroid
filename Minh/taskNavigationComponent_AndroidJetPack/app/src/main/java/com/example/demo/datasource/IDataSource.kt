package com.example.demo.datasource

import com.example.demo.data.model.MetaData
import retrofit2.Response

interface IDataSource {
    suspend fun getData():Response<MetaData>
}