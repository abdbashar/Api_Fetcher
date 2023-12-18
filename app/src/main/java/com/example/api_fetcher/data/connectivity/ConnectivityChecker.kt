package com.example.api_fetcher.data.connectivity

interface ConnectivityChecker {
    suspend fun hasInternetConnection(): Boolean
}
