package com.example.taskdeha.data.repository

import com.example.taskdeha.data.model.MetaData
import com.example.taskdeha.datasource.IDataSource
import retrofit2.Call
import retrofit2.Response

class MetaDataReposirotyImpl(val iDataSource: IDataSource):MetaDataRepository {
    override fun getData(): Call<MetaData> {
        return iDataSource.getData()
    }
}