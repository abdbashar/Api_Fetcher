package com.example.api_fetcher.data.repository

import com.example.api_fetcher.data.remote.response.ProductDTO

interface StoreRepository {
    suspend fun getProducts(): List<ProductDTO>
}