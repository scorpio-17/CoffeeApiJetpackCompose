package com.salman.freecoffeeapijetpackcompose.data.remote

sealed class    ApiResult<out T> {
    object Loading : ApiResult<Nothing>()
    data class Success<T>(val data: T) : ApiResult<T>()
    data class Error(val error: String) : ApiResult<Nothing>()
}
