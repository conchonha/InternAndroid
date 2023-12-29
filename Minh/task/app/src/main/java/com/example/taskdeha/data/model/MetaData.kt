package com.example.taskdeha.data.model

import com.google.gson.annotations.SerializedName

data class MetaData(
    @SerializedName("search_metadata") var searchMetadata: SearchMetadata? = SearchMetadata(),
    @SerializedName("search_parameters") var searchParameters: SearchParameters? = SearchParameters(),
    @SerializedName("search_information") var searchInformation: SearchInformation? = SearchInformation(),
    @SerializedName("suggested_searches") var suggestedSearches: ArrayList<SuggestedSearches> = arrayListOf(),
    @SerializedName("images_results") var imagesResults: ArrayList<ImagesResults> = arrayListOf(),
    @SerializedName("related_searches") var relatedSearches: ArrayList<RelatedSearches> = arrayListOf()
)
