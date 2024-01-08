package com.example.taskdeha.data.model

import com.google.gson.annotations.SerializedName

data class MenuItems(
    @SerializedName("position") var position: Int? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("link") var link: String? = null,
    @SerializedName("serpapi_link") var serpapiLink: String? = null
)
