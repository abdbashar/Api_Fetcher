package com.example.api_fetcher.data.remote.response

import com.google.gson.annotations.SerializedName

data class RatingDTO(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("rate")
    val rate: Double?
)
