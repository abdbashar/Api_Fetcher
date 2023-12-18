package com.example.api_fetcher.domain.mapper

import com.example.api_fetcher.data.remote.response.ProductDTO
import com.example.api_fetcher.data.remote.response.RatingDTO
import com.example.api_fetcher.domain.model.Product
import javax.inject.Inject

class ProductMapper @Inject constructor(
    private val ratingMapper: RatingMapper,
): Mapper<ProductDTO, Product>() {
    override fun map(input: ProductDTO): Product {
        val rating = ratingMapper.map(input.rating ?: RatingDTO(0,0.0))
        return Product(
            id = input.id ?: 0,
            title = input.title ?: "",
            price = input.price ?: 0.0,
            description = input.description ?: "",
            category = input.category ?: "",
            image = input.image ?: "",
            rating = rating
        )
    }
}