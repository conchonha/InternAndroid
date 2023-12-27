package com.example.learnnavigation.data.remote

import com.example.learnnavigation.data.model.Demo
import com.example.learnnavigation.data.model.Drink
import retrofit2.Call
import retrofit2.http.GET

interface DataService {

    @GET("search?engine=google_images&api_key=84ff28fca548fc850519a2db3cecd480d336701676b845d0be13d530eac75a7f&q=cafe")
    fun getDictionaries(): Call<Demo>
    @GET("api/json/v1/1/filter.php?c=Ordinary_Drink")
    fun getDrinks(): Call<Drink>
    @GET("api/json/v1/1/filter.php?i=Gin")
    fun getGin(): Call<Drink>
    @GET("api/json/v1/1/filter.php?i=Vodka")
    fun getVodka(): Call<Drink>

}