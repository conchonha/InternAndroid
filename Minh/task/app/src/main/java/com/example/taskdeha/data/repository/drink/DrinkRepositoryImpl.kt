package com.example.taskdeha.data.repository.drink

import com.example.taskdeha.data.model.Drinks
import com.example.taskdeha.datasource.IDataSource
import retrofit2.Call

class DrinkRepositoryImpl(val iDataSource: IDataSource) : DrinkRepository {
    override fun getDataDrink(): Call<Drinks> {
        return iDataSource.getDataDrink()
    }
}