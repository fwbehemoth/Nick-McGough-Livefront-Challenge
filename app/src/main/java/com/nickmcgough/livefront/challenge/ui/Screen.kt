package com.nickmcgough.livefront.challenge.ui

sealed class Screen(val route:String){
    object MainScreen : Screen("main_screen")
    object DetailsScreen : Screen("details_screen")
}
