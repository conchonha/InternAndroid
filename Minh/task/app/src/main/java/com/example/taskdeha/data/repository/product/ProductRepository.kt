package com.example.taskdeha.data.repository.product

import com.example.taskdeha.data.model.url2.Products
import retrofit2.Call

interface ProductRepository {
    fun getProduct(): Call<Products>
}