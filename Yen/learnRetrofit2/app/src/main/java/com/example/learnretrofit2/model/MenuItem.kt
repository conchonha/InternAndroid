package com.example.learnretrofit2.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MenuItem {

    @SerializedName("link")
    @Expose
    var link: String? = ""

    @SerializedName("position")
    @Expose
    private var position: Int? = 0

    @SerializedName("serpapi_link")
    @Expose
    var serpapi_link: String? = ""

    @SerializedName("title")
    @Expose
    var title: String? = ""

}