package com.example.taskdeha.data.model

import com.google.gson.annotations.SerializedName

data class Drinks(

    @SerializedName("drinks") var drinks: ArrayList<Drink> = arrayListOf()
)
