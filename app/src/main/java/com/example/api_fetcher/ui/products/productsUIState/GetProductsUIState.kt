package com.example.api_fetcher.ui.products.productsUIState

data class GetProductsUIState(
    val products: List<ProductUIState> = emptyList(),
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val isFailure: Boolean = false,
    val isInternetUnAvailable: Boolean = false,
    val isEmpty: Boolean = false,
    val error: String = ""
)
