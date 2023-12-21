package com.example.learnretrofit2.model

data class Chart(
    val images_results: List<ImagesResult>,
    val related_searches: List<RelatedSearche>,
    val search_information: SearchInformation,
    val search_metadata: SearchMetadata,
    val search_parameters: SearchParameters,
    val suggested_searches: List<SuggestedSearches>
)
