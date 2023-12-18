package com.example.api_fetcher.data.remote.exception

import java.io.IOException

sealed class NetworkException(message: String) : IOException(message) {
    object UnAuthorizedException : NetworkException("Unauthorized access")
    object ForbiddenException : NetworkException("Access to the resource is forbidden")
    object NotFoundException : NetworkException("The resource was not found")
    class UnknownException(code: Int) : NetworkException("Unknown error occurred with code: $code")
}
