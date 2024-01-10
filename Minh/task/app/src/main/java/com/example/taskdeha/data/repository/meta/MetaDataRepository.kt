package com.example.taskdeha.data.repository.meta

import com.example.taskdeha.data.model.MetaData
import retrofit2.Call
import retrofit2.Response

interface MetaDataRepository {
     fun getData():Call<MetaData>
}