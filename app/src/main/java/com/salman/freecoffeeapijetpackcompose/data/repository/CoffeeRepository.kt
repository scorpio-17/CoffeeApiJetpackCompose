package com.salman.freecoffeeapijetpackcompose.data.repository

import com.salman.freecoffeeapijetpackcompose.data.remote.ApiResult
import com.salman.freecoffeeapijetpackcompose.domain.model.GetCoffeeResponse
import kotlinx.coroutines.flow.Flow

interface CoffeeRepository {

    suspend fun getHotCoffeeList(): Flow<ApiResult<List<GetCoffeeResponse>>>

    suspend fun getIcedCoffeeList(): Flow<ApiResult<List<GetCoffeeResponse>>>

}