package com.nickmcgough.livefront.challenge.ui

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.nickmcgough.livefront.challenge.ui.composables.YelpBusinessList
import com.nickmcgough.livefront.challenge.yelp.composable.YelpBusinessDetailScreen
import com.nickmcgough.livefront.challenge.yelp.models.YelpBusinessInformationModel
import com.nickmcgough.livefront.challenge.yelp.viewmodels.YelpBusinessListViewModel

@Composable
fun Navigation(application: Application) {
    val navController = rememberNavController()
    val viewModel = YelpBusinessListViewModel(application)
    viewModel.newSearch()

    NavHost(navController = navController, startDestination = Screen.MainScreen.route){
        composable(route = Screen.MainScreen.route){
            YelpBusinessList(
                navController = navController,
                businesses = viewModel.businesses,
                loading = true,
                onChangeListScrollPosition = viewModel::onChangeListScrollPosition
            )
        }
        composable(
            route = Screen.DetailsScreen.route + "/{business}",
            arguments = listOf(
                navArgument("business"){
                    type = NavType.ParcelableType(YelpBusinessInformationModel::class.java)
                    nullable = true
            })
        ){ entry ->
            YelpBusinessDetailScreen(
                business = entry.arguments?.getParcelable<YelpBusinessInformationModel>(
                    "business")!!)
        }
    }

}