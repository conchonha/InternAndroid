package com.example.learnretrofit2.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SearchParameters {

    @SerializedName("device")
    @Expose
    var device: String? = ""

    @SerializedName("engine")
    @Expose
    var engine: String? = ""

    @SerializedName("gl")
    @Expose
    var gl: String? = ""

    @SerializedName("google_domain")
    @Expose
    var google_domain: String? = ""

    @SerializedName("hl")
    @Expose
    var hl: String? = ""

    @SerializedName("q")
    @Expose
    var q: String? = ""
}