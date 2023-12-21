package com.example.learnretrofit2.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RelatedSearche {

    @SerializedName("highlighted_words")
    @Expose
    lateinit var highlighted_words: List<String>

    @SerializedName("link")
    @Expose
    var link: String? = ""

    @SerializedName("query")
    @Expose
    var query: String? = ""

    @SerializedName("serpapi_link")
    @Expose
    var serpapi_link: String? = ""

    @SerializedName("thumbnail")
    @Expose
    var thumbnail: String? = ""

}