package com.example.api_fetcher.domain.usecase

import com.example.api_fetcher.data.repository.StoreRepository
import com.example.api_fetcher.domain.mapper.ProductMapper
import com.example.api_fetcher.domain.model.Product
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val storeRepository: StoreRepository,
    private val newProductMapper: ProductMapper
) {
    suspend operator fun invoke(): List<Product> {
        return storeRepository.getProducts().map { newProductMapper.map(it) }
    }
}