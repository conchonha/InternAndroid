package com.example.learnretrofit2.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class SuggestedSearches {
    @SerializedName("chips")
    @Expose
    var chips: String? = ""

    @SerializedName("link")
    @Expose
    var link: String? = ""

    @SerializedName("name")
    @Expose
    var name: String? = ""

    @SerializedName("serpapi_link")
    @Expose
    var serpapi_link: String? = ""

    @SerializedName("thumbnail")
    @Expose
    var thumbnail: String? = ""
}