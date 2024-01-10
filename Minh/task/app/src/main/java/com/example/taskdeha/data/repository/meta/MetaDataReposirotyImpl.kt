package com.example.taskdeha.data.repository.meta

import com.example.taskdeha.data.model.MetaData
import com.example.taskdeha.datasource.IDataSource
import retrofit2.Call

class MetaDataReposirotyImpl(val iDataSource: IDataSource): MetaDataRepository {
    override fun getData(): Call<MetaData> {
        return iDataSource.getData()
    }
}