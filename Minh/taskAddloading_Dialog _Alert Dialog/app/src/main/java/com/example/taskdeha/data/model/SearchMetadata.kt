package com.example.taskdeha.data.model

import com.google.gson.annotations.SerializedName

data class SearchMetadata(
    @SerializedName("id") var id: String? = null,
    @SerializedName("status") var status: String? = null,
    @SerializedName("json_endpoint") var jsonEndpoint: String? = null,
    @SerializedName("created_at") var createdAt: String? = null,
    @SerializedName("processed_at") var processedAt: String? = null,
    @SerializedName("google_images_url") var googleImagesUrl: String? = null,
    @SerializedName("raw_html_file") var rawHtmlFile: String? = null,
    @SerializedName("total_time_taken") var totalTimeTaken: Double? = null
)
