package com.example.learnnavigation.data.remote

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Arrays
import java.util.concurrent.TimeUnit


object APIRetrofitClient {
    private var retrofit: Retrofit? = null
    fun getClient(baseurl: String?): Retrofit? {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val okHttpClient =
            OkHttpClient.Builder() //những thao tác những giao thức tương tác với mạng
                .readTimeout(10000, TimeUnit.MILLISECONDS) //thời gian ngắt đọc phía sever
                .writeTimeout(10000, TimeUnit.MILLISECONDS) //thời gian ngắt
                .connectTimeout(10000, TimeUnit.MILLISECONDS) //thời gian kết nối
                .retryOnConnectionFailure(true) //tự động kết nối lại nếu lỗi mạng
                .protocols(Arrays.asList(Protocol.HTTP_1_1)) //giao thức kết nối
                .addInterceptor(logging)
                .build()
        val gson = GsonBuilder().setLenient()
            .create() //cấu hình json. json dùng để convert từ khóa json api trả về thành biến json của java

        retrofit = Retrofit.Builder()
            .baseUrl(baseurl)
            .client(okHttpClient) //cấu hình những phương thức của mạng
            .addConverterFactory(GsonConverterFactory.create(gson)) //convert dữ liệu của api thành biến của java
            .build()
        return retrofit
    }
}