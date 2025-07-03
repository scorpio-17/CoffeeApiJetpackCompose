package com.salman.freecoffeeapijetpackcompose.data.remote

import com.salman.freecoffeeapijetpackcompose.domain.model.GetCoffeeResponse
import com.salman.freecoffeeapijetpackcompose.utils.Constants
import retrofit2.http.GET

interface ApiInterface {

    @GET(Constants.GET_HOT_COFFEE_END_POINT)
    suspend fun getHotCoffeeList(): List<GetCoffeeResponse>

    @GET(Constants.GET_ICED_COFFEE_END_POINT)
    suspend fun getIcedCoffeeList(): List<GetCoffeeResponse>

}