package com.example.taskdeha.data.repository.product

import com.example.taskdeha.data.model.url2.Products
import com.example.taskdeha.datasource.IDataSource
import retrofit2.Call

class ProductRepositoryImpl(val iDataSource: IDataSource):ProductRepository {
    override fun getProduct(): Call<Products> {
        return iDataSource.getProduct()
    }
}