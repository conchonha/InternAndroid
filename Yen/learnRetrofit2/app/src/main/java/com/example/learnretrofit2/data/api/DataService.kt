package com.example.learnretrofit2.data.api

import com.example.learnretrofit2.model.Chart
import retrofit2.Call
import retrofit2.http.GET

interface DataService {

    @GET("search?engine=google_images&api_key=84ff28fca548fc850519a2db3cecd480d336701676b845d0be13d530eac75a7f&q=cafe")
    fun getDictionaries(): Call<Chart>

}