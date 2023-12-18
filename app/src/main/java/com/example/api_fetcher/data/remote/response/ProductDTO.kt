package com.example.api_fetcher.data.remote.response

import com.google.gson.annotations.SerializedName

data class ProductDTO(
    @SerializedName("category")
    val category: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("price")
    val price: Double?,
    @SerializedName("rating")
    val rating: RatingDTO?,
    @SerializedName("title")
    val title: String?
)
