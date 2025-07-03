package com.salman.freecoffeeapijetpackcompose.presentation.ui.main_screen

import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.salman.freecoffeeapijetpackcompose.R
import com.salman.freecoffeeapijetpackcompose.data.remote.ApiResult
import com.salman.freecoffeeapijetpackcompose.presentation.common.BackgroundScreen
import com.salman.freecoffeeapijetpackcompose.presentation.ui.main_screen.component.CoffeeItemView
import com.salman.freecoffeeapijetpackcompose.presentation.view_model.CoffeeViewModel
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun MainScreen(viewModel: CoffeeViewModel = hiltViewModel(), coffeeType: String) {

    Toast.makeText(LocalContext.current, coffeeType, Toast.LENGTH_SHORT).show()
    val flow = when (coffeeType) {
        "hot" -> viewModel.hotCoffeeList
        "iced" -> viewModel.icedCoffeeList
        else -> MutableStateFlow(ApiResult.Error("Unknown coffee type"))
    }

    val coffeeState by flow.collectAsState()

    LaunchedEffect(coffeeType) {
        if (coffeeType == "hot") viewModel.getHotCoffeeList()
        else viewModel.getIcedCoffeeList()
    }

    BackgroundScreen(backgroundResId = R.drawable.ic_background_two) {
        when (coffeeState) {
            is ApiResult.Loading -> {
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                )
            }

            is ApiResult.Success -> {
                val coffeeData = (coffeeState as ApiResult.Success).data
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(10.dp)
                ) {
                    items(coffeeData) { item ->
                        CoffeeItemView(item)
                    }
                }
            }

            is ApiResult.Error -> {
                val message = (coffeeState as ApiResult.Error).error
                Text(
                    text = "Error: $message",
                    color = Color.Red,
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                )
            }
        }
    }

}
