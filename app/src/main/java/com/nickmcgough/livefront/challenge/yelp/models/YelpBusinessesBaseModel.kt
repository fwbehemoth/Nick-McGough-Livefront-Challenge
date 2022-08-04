package com.nickmcgough.livefront.challenge.yelp.models

import com.nickmcgough.livefront.challenge.models.CoordinatesModel

data class YelpBusinessesBaseModel(
    val total:Int? = null,
    var businesses:ArrayList<YelpBusinessInformationModel>? = null,
    val region: CoordinatesModel? = null
)
