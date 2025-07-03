package com.salman.freecoffeeapijetpackcompose.presentation.nav_graph

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.salman.freecoffeeapijetpackcompose.presentation.ui.main_screen.MainScreen
import com.salman.freecoffeeapijetpackcompose.presentation.ui.selection_screen.SelectionScreen


@Composable
fun AppNavHost(navController: NavHostController = rememberNavController()) {

    NavHost(navController = navController, startDestination = Screens.SelectionScreen.route) {
        composable(Screens.SelectionScreen.route) {
            SelectionScreen { selectedType ->
                navController.navigate(Screens.CoffeeMainScreen.routeWithType(selectedType))
            }
        }

        composable(
            route = Screens.CoffeeMainScreen.route,
            arguments = listOf(navArgument("type") { type = NavType.StringType })
        ) {
            val typeArg = it.arguments?.getString("type")
            MainScreen(coffeeType = typeArg.toString())
        }
    }

}