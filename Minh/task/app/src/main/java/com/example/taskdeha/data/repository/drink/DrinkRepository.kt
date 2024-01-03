package com.example.taskdeha.data.repository.drink

import com.example.taskdeha.data.model.Drinks
import com.example.taskdeha.data.model.MetaData
import retrofit2.Call

interface DrinkRepository {
    fun getDataDrink(): Call<Drinks>
}