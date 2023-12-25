package com.example.learnnavigation.model

import com.google.gson.annotations.SerializedName

data class SearchParameters (
    @SerializedName("engine"        ) var engine       : String? = null,
    @SerializedName("q"             ) var q            : String? = null,
    @SerializedName("google_domain" ) var googleDomain : String? = null,
    @SerializedName("hl"            ) var hl           : String? = null,
    @SerializedName("gl"            ) var gl           : String? = null,
    @SerializedName("device"        ) var device       : String? = null
)