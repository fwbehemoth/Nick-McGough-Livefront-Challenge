package com.nickmcgough.livefront.challenge.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.nickmcgough.livefront.challenge.yelp.models.YelpBusinessInformationModel

@Composable
fun YelpBusinessCard(
    business: YelpBusinessInformationModel?,
    onClick: () -> Unit,
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                bottom = 6.dp,
                top = 6.dp,
            )
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = 8.dp,
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 0.dp, bottom = 2.dp, start = 8.dp, end = 8.dp)
            ) {
                business?.name?.let { name ->
                    Text(
                        text = name,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.CenterHorizontally),
                        style = MaterialTheme.typography.h5
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp, bottom = 12.dp, start = 8.dp, end = 8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .height(120.dp)
                            .width(120.dp)
                            .background(Color.Gray)
                    )
                //            recipe.featuredImage?.let { url ->
                //                Image(
                //                    bitmap = imageResource(id = R.drawable.empty_plate),
                //                    modifier = Modifier
                //                        .fillMaxWidth()
                //                        .preferredHeight(225.dp),
                //                    contentScale = ContentScale.Crop,
                //                )
                //            }
                    Column() {
                        Row(
                            modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 4.dp, bottom = 2.dp, start = 8.dp, end = 8.dp)
                            ) {
                                Text(
                                    text = business?.rating.toString(),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .wrapContentWidth(Alignment.End)
                                        .align(Alignment.Top),
                                    style = MaterialTheme.typography.h6
                                )
                            }
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 4.dp, bottom = 2.dp, start = 8.dp, end = 8.dp)
                            ) {
                                Text(
                                    text = business?.price!!,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .wrapContentWidth(Alignment.End)
                                        .align(Alignment.Top),
                                    style = MaterialTheme.typography.h6
                                )
                            }
                        }
                    }
                }
            }
        }
    }