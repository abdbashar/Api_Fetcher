package com.example.api_fetcher.domain.usecase

import com.example.api_fetcher.data.connectivity.ConnectivityChecker
import javax.inject.Inject

class CheckConnectivityUseCase @Inject constructor(
    private val connectivityChecker: ConnectivityChecker
) {
    suspend operator fun invoke(): Boolean = connectivityChecker.hasInternetConnection()
}
