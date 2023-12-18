package com.example.api_fetcher.domain.mapper

import com.example.api_fetcher.data.remote.response.RatingDTO
import com.example.api_fetcher.domain.model.Rating
import javax.inject.Inject

class RatingMapper @Inject constructor(): Mapper<RatingDTO, Rating>() {
    override fun map(input: RatingDTO): Rating {
        return Rating(
            count = input.count ?: 0,
            rate = input.rate ?: 0.0
        )
    }
}