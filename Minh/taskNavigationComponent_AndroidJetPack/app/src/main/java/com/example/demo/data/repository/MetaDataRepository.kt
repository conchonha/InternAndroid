package com.example.demo.data.repository

import com.example.demo.data.model.MetaData
import retrofit2.Call
import retrofit2.Response

interface MetaDataRepository {
     suspend fun getData():Response<MetaData>
}