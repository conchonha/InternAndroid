package com.example.learnnavigation.data.model

import com.google.gson.annotations.SerializedName

data class Drink( @SerializedName("drinks" ) var drinks : ArrayList<Drinks> = arrayListOf()
)
