package com.example.api_fetcher.ui.products.productUIMapper

import com.example.api_fetcher.domain.mapper.Mapper
import com.example.api_fetcher.domain.model.Rating
import com.example.api_fetcher.ui.products.productsUIState.RatingUIState
import javax.inject.Inject

class RateUIMapper @Inject constructor(): Mapper<Rating, RatingUIState>() {
    override fun map(input: Rating): RatingUIState {
        return RatingUIState(
            count = input.count,
            rate = input.rate
        )
    }
}