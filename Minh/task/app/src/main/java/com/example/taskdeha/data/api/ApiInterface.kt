package com.example.taskdeha.data.api

import com.example.taskdeha.data.model.Drinks
import com.example.taskdeha.data.model.MetaData
import com.example.taskdeha.data.model.url2.Products
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("/search?engine=google_images&api_key=84ff28fca548fc850519a2db3cecd480d336701676b845d0be13d530eac75a7f&q=cafe")
    fun getData(): Call<MetaData>

    @GET("api/json/v1/1/filter.php?c=Ordinary_Drink")
    fun getDrinks(): Call<Drinks>

    @GET("products/hot")
    fun getHotBook(): Call<Products>
}