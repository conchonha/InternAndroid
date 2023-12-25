package com.example.demo.data.model

import com.google.gson.annotations.SerializedName

data class SearchInformation(
    @SerializedName("image_results_state") var imageResultsState: String? = null,
    @SerializedName("menu_items") var menuItems: ArrayList<MenuItems> = arrayListOf()
)
