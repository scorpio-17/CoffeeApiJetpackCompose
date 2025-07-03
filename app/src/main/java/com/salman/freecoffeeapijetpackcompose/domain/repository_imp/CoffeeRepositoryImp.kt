package com.salman.freecoffeeapijetpackcompose.domain.repository_imp

import com.salman.freecoffeeapijetpackcompose.data.remote.ApiInterface
import com.salman.freecoffeeapijetpackcompose.data.remote.ApiResult
import com.salman.freecoffeeapijetpackcompose.data.repository.CoffeeRepository
import com.salman.freecoffeeapijetpackcompose.domain.model.GetCoffeeResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CoffeeRepositoryImp @Inject constructor(
    private val apiInterface: ApiInterface
) : CoffeeRepository {

    override suspend fun getHotCoffeeList(): Flow<ApiResult<List<GetCoffeeResponse>>> = flow {
        try {
            emit(ApiResult.Loading)
            val response = apiInterface.getHotCoffeeList()
            emit(ApiResult.Success(response))
        } catch (e: Exception) {
            emit(ApiResult.Error(e.localizedMessage ?: "Unknown Error"))
        }
    }

    override suspend fun getIcedCoffeeList(): Flow<ApiResult<List<GetCoffeeResponse>>> = flow {
        try {
            emit(ApiResult.Loading)
            val response = apiInterface.getIcedCoffeeList()
            emit(ApiResult.Success(response))
        } catch (e: Exception) {
            emit(ApiResult.Error(e.localizedMessage ?: "Unknown Error"))
        }
    }



}