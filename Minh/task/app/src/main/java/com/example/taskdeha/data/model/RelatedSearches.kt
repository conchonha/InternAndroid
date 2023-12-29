package com.example.taskdeha.data.model

import com.google.gson.annotations.SerializedName

data class RelatedSearches(
    @SerializedName("link") var link: String? = null,
    @SerializedName("serpapi_link") var serpapiLink: String? = null,
    @SerializedName("query") var query: String? = null,
    @SerializedName("highlighted_words") var highlightedWords: ArrayList<String> = arrayListOf(),
    @SerializedName("thumbnail") var thumbnail: String? = null
)
