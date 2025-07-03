package com.salman.freecoffeeapijetpackcompose.presentation.nav_graph

sealed class Screens(val route: String) {

    object SelectionScreen : Screens("selection")

    object CoffeeMainScreen : Screens("coffeeMainScreen/{type}") {
        fun routeWithType(type: String) = "coffeeMainScreen/$type"
    }

}