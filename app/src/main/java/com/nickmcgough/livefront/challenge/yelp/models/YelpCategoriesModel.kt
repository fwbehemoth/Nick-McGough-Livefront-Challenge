package com.nickmcgough.livefront.challenge.yelp.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class YelpCategoriesModel(
    val alias:String? = null,
    val title:String? = null,
) : Parcelable