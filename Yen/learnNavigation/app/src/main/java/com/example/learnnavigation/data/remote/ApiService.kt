package com.example.learnnavigation.data.remote


object ApiService {
    private const val BASE_URL = "https://serpapi.com/"
    private const val BASE_URL_2 = "https://www.thecocktaildb.com/"


    fun getService(): DataService {
        return APIRetrofitClient.getClient(BASE_URL)!!.create(DataService::class.java)
    }
    fun getService_2(): DataService {
        return APIRetrofitClient.getClient(BASE_URL_2)!!.create(DataService::class.java)
    }
}
