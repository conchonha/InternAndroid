package com.example.demo.data.repository

import com.example.demo.data.model.MetaData
import com.example.demo.datasource.IDataSource
import retrofit2.Response

class MetaDataReposirotyImpl(val iDataSource: IDataSource):MetaDataRepository {
    override suspend fun getData(): Response<MetaData> {
        return iDataSource.getData()
    }
}