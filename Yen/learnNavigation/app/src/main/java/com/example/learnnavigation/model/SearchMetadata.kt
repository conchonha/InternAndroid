package com.example.learnnavigation.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SearchMetadata {

    @SerializedName("created_at")
    @Expose
    var created_at: String? = ""

    @SerializedName("google_images_url")
    @Expose
    var google_images_url: String? = ""

    @SerializedName("id")
    @Expose
    var id: String? = ""

    @SerializedName("json_endpoint")
    @Expose
    var json_endpoint: String? = ""

    @SerializedName("processed_at")
    @Expose
    var processed_at: String? = ""

    @SerializedName("raw_html_file")
    @Expose
    var raw_html_file: String? = ""

    @SerializedName("status")
    @Expose
    var status: String? = ""

    @SerializedName("total_time_taken")
    @Expose
     var total_time_taken: Double? = 0.0
}