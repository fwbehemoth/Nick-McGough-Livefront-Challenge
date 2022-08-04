package com.nickmcgough.livefront.challenge.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.nickmcgough.livefront.challenge.ui.Screen
import com.nickmcgough.livefront.challenge.yelp.models.YelpBusinessInformationModel

@Composable
fun YelpBusinessList(
    navController: NavController,
    businesses:ArrayList<YelpBusinessInformationModel>,
    loading:Boolean,
    onChangeListScrollPosition: (Int) -> Unit,
) {
    Box(modifier = Modifier
        .background(color = MaterialTheme.colors.surface)
    ) {
        if (loading && businesses.isEmpty()) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = "Loading"
            )
        }
        else if(businesses.isEmpty()){
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = "No results"
            )
        }
        else {
            LazyColumn{
                itemsIndexed(
                    items = businesses
                ) { index, business ->
                    onChangeListScrollPosition(index)
                    YelpBusinessCard(
                        business = business,
                        onClick = {
                            navController.navigate(Screen.DetailsScreen.route + business)
                        }
                    )
                }
            }
        }
    }
}