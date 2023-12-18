package com.example.api_fetcher.domain.mapper

abstract class Mapper<I, O> {
    abstract fun map(input: I): O
}