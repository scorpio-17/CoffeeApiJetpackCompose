package com.salman.freecoffeeapijetpackcompose.presentation.ui.selection_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.salman.freecoffeeapijetpackcompose.R
import com.salman.freecoffeeapijetpackcompose.presentation.common.BackgroundScreen
import com.salman.freecoffeeapijetpackcompose.presentation.ui.selection_screen.component.CoffeeOptionCard

@Composable
fun SelectionScreen(onClick:  (String) -> Unit) {

    BackgroundScreen() {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Choose Your Favourite Beverage",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.brown)
                )

                Row {
                    CoffeeOptionCard(onClick = {
                        onClick("hot")
                    }, imageResId = R.drawable.ic_hot_coffee)

                    Spacer(Modifier.width(5.dp))

                    CoffeeOptionCard(onClick = {
                        onClick("iced")
                    }, imageResId = R.drawable.ic_cold_coffee)

                }
            }
        }
    }

}