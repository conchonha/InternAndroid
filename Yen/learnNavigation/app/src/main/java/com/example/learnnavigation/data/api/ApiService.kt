package com.example.learnnavigation.data.api


object ApiService {
    private const val BASE_URL = "https://serpapi.com/"

    fun getService(): DataService {
        return APIRetrofitClient.getClient(BASE_URL)!!.create(DataService::class.java)
    }

}