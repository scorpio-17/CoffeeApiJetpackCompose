package com.salman.freecoffeeapijetpackcompose.presentation.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.salman.freecoffeeapijetpackcompose.data.remote.ApiResult
import com.salman.freecoffeeapijetpackcompose.data.repository.CoffeeRepository
import com.salman.freecoffeeapijetpackcompose.domain.model.GetCoffeeResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoffeeViewModel @Inject constructor(
    private val coffeeRepository: CoffeeRepository
) : ViewModel() {

    private val _hotCoffeeList =
        MutableStateFlow<ApiResult<List<GetCoffeeResponse>>>(ApiResult.Loading)
    var hotCoffeeList: StateFlow<ApiResult<List<GetCoffeeResponse>>> = _hotCoffeeList

    private val _icedCoffeeList =
        MutableStateFlow<ApiResult<List<GetCoffeeResponse>>>(ApiResult.Loading)
    var icedCoffeeList: StateFlow<ApiResult<List<GetCoffeeResponse>>> = _icedCoffeeList

    fun getHotCoffeeList() = viewModelScope.launch {
        coffeeRepository.getHotCoffeeList().collect {
            _hotCoffeeList.value = it
        }
    }

    fun getIcedCoffeeList() = viewModelScope.launch {
        coffeeRepository.getIcedCoffeeList().collect {
            _icedCoffeeList.value = it
        }
    }

}