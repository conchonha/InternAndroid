package com.example.learnnavigation.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SearchInformation {
    @SerializedName("image_results_state")
    @Expose
    var image_results_state: String? = ""

    val menu_items: List<MenuItem>
        get() {
            TODO()
        }

}