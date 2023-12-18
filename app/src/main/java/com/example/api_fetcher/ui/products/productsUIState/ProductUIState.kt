package com.example.api_fetcher.ui.products.productsUIState

data class ProductUIState(
    val category: String = "",
    val description: String = "",
    val id: Int = 0,
    val image: String = "",
    val price: Double = 0.0,
    val rating: RatingUIState = RatingUIState(),
    val title: String = "",
)