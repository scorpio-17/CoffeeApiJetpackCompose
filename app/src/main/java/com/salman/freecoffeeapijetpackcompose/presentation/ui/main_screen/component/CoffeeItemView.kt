package com.salman.freecoffeeapijetpackcompose.presentation.ui.main_screen.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.salman.freecoffeeapijetpackcompose.R
import com.salman.freecoffeeapijetpackcompose.domain.model.GetCoffeeResponse


@Composable
fun CoffeeItemView(item: GetCoffeeResponse) {

    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .width(180.dp)
            .wrapContentHeight()
            .padding(10.dp)
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                contentScale = ContentScale.Crop,
                model = item.image,
                contentDescription = null
            )

            item.title?.let {
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    modifier = Modifier.padding(bottom = 10.dp),
                    text = it,
                    color = colorResource(R.color.brown),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }

    }

}

@Preview
@Composable
fun CoffeeItemViewPreview() {
    CoffeeItemView(GetCoffeeResponse())
}