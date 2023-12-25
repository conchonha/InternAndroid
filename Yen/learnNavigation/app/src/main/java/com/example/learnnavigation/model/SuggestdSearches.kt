package com.example.learnnavigation.model

import com.google.gson.annotations.SerializedName


data class SuggestedSearches (

    @SerializedName("name"         ) var name        : String? = null,
    @SerializedName("link"         ) var link        : String? = null,
    @SerializedName("chips"        ) var chips       : String? = null,
    @SerializedName("serpapi_link" ) var serpapiLink : String? = null,
    @SerializedName("thumbnail"    ) var thumbnail   : String? = null

)