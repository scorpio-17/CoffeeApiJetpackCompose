package com.salman.freecoffeeapijetpackcompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.salman.freecoffeeapijetpackcompose.presentation.nav_graph.AppNavHost
import com.salman.freecoffeeapijetpackcompose.presentation.nav_graph.Screens
import com.salman.freecoffeeapijetpackcompose.presentation.ui.selection_screen.SelectionScreen
import com.salman.freecoffeeapijetpackcompose.ui.theme.FreeCoffeeApiJetpackComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            FreeCoffeeApiJetpackComposeTheme {
                AppNavHost()
            }
        }
    }
}

