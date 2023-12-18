package com.example.api_fetcher.ui.products.productUIMapper

import com.example.api_fetcher.domain.mapper.Mapper
import com.example.api_fetcher.domain.model.Product
import com.example.api_fetcher.ui.products.productsUIState.ProductUIState
import javax.inject.Inject

class ProductUIMapper @Inject constructor(
    private val rateUIMapper: RateUIMapper
): Mapper<Product, ProductUIState>(){
    override fun map(input: Product): ProductUIState {
        val rating = rateUIMapper.map(input.rating)
        return ProductUIState(
            id = input.id,
            title = input.title,
            price = input.price,
            description = input.description,
            category = input.category,
            image = input.image,
            rating = rating
        )
    }
}