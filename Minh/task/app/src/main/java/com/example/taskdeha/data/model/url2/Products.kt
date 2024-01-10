package com.example.taskdeha.data.model.url2

import com.google.gson.annotations.SerializedName

data class Products(
    @SerializedName("count"    ) var count    : Int?                = null,
    @SerializedName("products" ) var products : List<Product>
)
