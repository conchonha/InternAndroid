package com.example.learnretrofit2.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class ImagesResult {

    @SerializedName("is_product")
    @Expose
    var is_product: Boolean = true

    @SerializedName("link")
    @Expose
    var link: String? = ""

    @SerializedName("original")
    @Expose
    var original: String? = ""

    @SerializedName("original_height")
    @Expose
    private var original_height: Int? = 0

    @SerializedName("original_width")
    @Expose
    private var original_width: Int? = 0

    @SerializedName("position")
    @Expose
    private var position: Int? = 0

    @SerializedName("related_content_id")
    @Expose
    var related_content_id: String? = ""

    @SerializedName("serpapi_related_content_link")
    @Expose
    var serpapi_related_content_link: String? = ""

    @SerializedName("source")
    @Expose
    var source: String? = ""

    @SerializedName("source_logo")
    @Expose
    var source_logo: String? = ""

    @SerializedName("tag")
    @Expose
    var tag: String? = ""

    @SerializedName("thumbnail")
    @Expose
    var thumbnail: String? = ""

    @SerializedName("title")
    @Expose
    var title: String? = ""

}