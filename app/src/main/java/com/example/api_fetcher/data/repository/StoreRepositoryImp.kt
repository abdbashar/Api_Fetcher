package com.example.api_fetcher.data.repository

import com.example.api_fetcher.data.remote.exception.NetworkException
import com.example.api_fetcher.data.remote.response.ProductDTO
import com.example.api_fetcher.data.remote.service.StoreApiService
import retrofit2.Response
import javax.inject.Inject

class StoreRepositoryImp @Inject constructor(
    private val storeApiService: StoreApiService
) : StoreRepository {

    override suspend fun getProducts(): List<ProductDTO> = executeSafely { storeApiService.getProducts() }

    private suspend fun <T> executeSafely(apiCall: suspend () -> Response<T>): T {
        val response = apiCall()
        return if (response.isSuccessful) response.body() ?: throw NetworkException.NotFoundException
        else throw mapStatusCodeToException(response.code())
    }

    private fun mapStatusCodeToException(code: Int): NetworkException {
        return when (code) {
            401 -> NetworkException.UnAuthorizedException
            403 -> NetworkException.ForbiddenException
            404 -> NetworkException.NotFoundException
            else -> NetworkException.UnknownException(code)
        }
    }
}