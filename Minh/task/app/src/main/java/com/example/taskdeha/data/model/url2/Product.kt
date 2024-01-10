package com.example.taskdeha.data.model.url2

import com.google.gson.annotations.SerializedName


data class Product (
    @SerializedName("product_id"       ) var productId       : Int?    = null,
    @SerializedName("name"             ) var name            : String? = null,
    @SerializedName("description"      ) var description     : String? = null,
    @SerializedName("price"            ) var price           : String? = null,
    @SerializedName("discounted_price" ) var discountedPrice : String? = null,
    @SerializedName("quantity"         ) var quantity        : Int?    = null,
    @SerializedName("quantitySold"     ) var quantitySold    : Int?    = null,
    @SerializedName("thumbnail"        ) var thumbnail       : String? = null,
    @SerializedName("supplierName"     ) var supplierName    : String? = null
)
