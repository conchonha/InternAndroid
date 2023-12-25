package com.example.demo.data.api

import com.example.demo.data.model.MetaData
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("/search?engine=google_images&api_key=84ff28fca548fc850519a2db3cecd480d336701676b845d0be13d530eac75a7f&q=cafe")
    suspend fun getData(): Response<MetaData>
//    fun getData(): Call<MetaData>

}