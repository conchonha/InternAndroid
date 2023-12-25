package com.example.learnnavigation.model

import com.google.gson.annotations.SerializedName

data class MenuItem  (

    @SerializedName("position"     ) var position    : Int?    = null,
    @SerializedName("title"        ) var title       : String? = null,
    @SerializedName("link"         ) var link        : String? = null,
    @SerializedName("serpapi_link" ) var serpapiLink : String? = null

)