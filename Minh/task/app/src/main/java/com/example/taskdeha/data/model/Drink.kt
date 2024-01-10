package com.example.taskdeha.data.model

import com.google.gson.annotations.SerializedName

data class Drink(
    @SerializedName("strDrink") var strDrink: String? = null,
    @SerializedName("strDrinkThumb") var strDrinkThumb: String? = null,
    @SerializedName("idDrink") var idDrink: String? = null
)