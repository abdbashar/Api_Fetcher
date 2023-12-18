package com.example.api_fetcher.util

import androidx.lifecycle.MutableLiveData

fun <T> MutableLiveData<Event<T>>.postEvent(content: T) {
    postValue(Event(content))
}

