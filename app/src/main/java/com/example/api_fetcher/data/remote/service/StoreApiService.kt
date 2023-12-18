package com.example.api_fetcher.data.remote.service

import com.example.api_fetcher.data.remote.response.ProductDTO
import retrofit2.Response
import retrofit2.http.GET

interface StoreApiService {
    @GET("products")
    suspend fun getProducts(): Response<List<ProductDTO>>
}