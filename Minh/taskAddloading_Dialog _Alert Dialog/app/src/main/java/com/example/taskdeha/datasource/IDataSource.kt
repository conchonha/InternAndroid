package com.example.taskdeha.datasource

import com.example.taskdeha.data.model.MetaData
import retrofit2.Call
import retrofit2.Response

interface IDataSource {
     fun getData():Call<MetaData>
}