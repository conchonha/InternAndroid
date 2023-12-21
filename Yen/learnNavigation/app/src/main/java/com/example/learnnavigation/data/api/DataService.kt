package com.example.learnnavigation.data.api

import com.example.learnnavigation.model.Demo
import retrofit2.Call
import retrofit2.http.GET

interface DataService {

    @GET("search?engine=google_images&api_key=84ff28fca548fc850519a2db3cecd480d336701676b845d0be13d530eac75a7f&q=cafe")
    fun getDictionaries(): Call<Demo>

}