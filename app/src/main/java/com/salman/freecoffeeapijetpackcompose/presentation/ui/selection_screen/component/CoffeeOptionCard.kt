package com.salman.freecoffeeapijetpackcompose.presentation.ui.selection_screen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.salman.freecoffeeapijetpackcompose.R

@Composable
fun CoffeeOptionCard(
    imageResId: Int = R.drawable.ic_hot_coffee,
    onClick: () -> Unit,
    backgroundColor: Color = colorResource(R.color.faWhite)
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .size(width = 140.dp, height = 160.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {

        Image(
            painter = painterResource(id = imageResId),
            contentDescription = "image",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )

    }
}

@Preview
@Composable
fun CoffeeOptionCardPreview() {
    CoffeeOptionCard( onClick = {})
}
