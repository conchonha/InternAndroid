package com.example.taskdeha.data.api


import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit

object RetrofitClient {
    private const val BASE_URL = "https://serpapi.com/"
    private const val BASE_URL_2 = "https://www.thecocktaildb.com/"
    private const val BASE_URL_3 = "https://ab53-118-71-204-98.ngrok-free.app/"

    //    private val retrofit: Retrofit by lazy {
//        createRetrofit(BASE_URL)
//    }
    private val retrofit1: Retrofit by lazy {
        createRetrofit(BASE_URL)
    }
    private val retrofit2: Retrofit by lazy {
        createRetrofit(BASE_URL_2)
    }
    private val retrofit3: Retrofit by lazy {
        createRetrofit(BASE_URL_3)
    }

    private fun createRetrofit(baseUrl: String): Retrofit {
        val httpClient = OkHttpClient.Builder()
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val okHttpClient =
            OkHttpClient.Builder() //những thao tác những giao thức tương tác với mạng
                .connectTimeout(7, TimeUnit.SECONDS) // Đặt thời gian kết nối tối đa
                .readTimeout(7, TimeUnit.SECONDS)    // Đặt thời gian đọc dữ liệu tối đa
                .writeTimeout(7, TimeUnit.SECONDS)   // Đặt thời gian ghi dữ liệu tối đa
                .retryOnConnectionFailure(true) //tự động kết nối lại nếu lỗi mạng
                .protocols(listOf(Protocol.HTTP_1_1)) //giao thức kết nối
                .addInterceptor(logging)
                .build()
//        val client = httpClient.build()
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())

            .client(okHttpClient)
            .build()
    }

    val apiService: ApiInterface by lazy {
        retrofit1.create(ApiInterface::class.java)
    }
    val apiService2: ApiInterface by lazy {
        retrofit2.create(ApiInterface::class.java)
    }
    val apiService3: ApiInterface by lazy {
        retrofit3.create(ApiInterface::class.java)
    }
}