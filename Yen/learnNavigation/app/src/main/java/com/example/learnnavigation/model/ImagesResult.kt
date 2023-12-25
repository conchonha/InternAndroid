package com.example.learnnavigation.model

import com.google.gson.annotations.SerializedName


data class ImagesResults (

    @SerializedName("position"                     ) var position                  : Int?     = null,
    @SerializedName("thumbnail"                    ) var thumbnail                 : String?  = null,
    @SerializedName("related_content_id"           ) var relatedContentId          : String?  = null,
    @SerializedName("serpapi_related_content_link" ) var serpapiRelatedContentLink : String?  = null,
    @SerializedName("source"                       ) var source                    : String?  = null,
    @SerializedName("source_logo"                  ) var sourceLogo                : String?  = null,
    @SerializedName("title"                        ) var title                     : String?  = null,
    @SerializedName("link"                         ) var link                      : String?  = null,
    @SerializedName("original"                     ) var original                  : String?  = null,
    @SerializedName("original_width"               ) var originalWidth             : Int?     = null,
    @SerializedName("original_height"              ) var originalHeight            : Int?     = null,
    @SerializedName("is_product"                   ) var isProduct                 : Boolean? = null

)