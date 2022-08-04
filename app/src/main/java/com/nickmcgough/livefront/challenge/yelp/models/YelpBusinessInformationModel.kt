package com.nickmcgough.livefront.challenge.yelp.models

import android.os.Parcelable
import com.nickmcgough.livefront.challenge.models.BusinessAddressModel
import com.nickmcgough.livefront.challenge.models.CoordinatesModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class YelpBusinessInformationModel (
    val rating:String? = null,
    val price:String? = null,
    val phone:String? = null,
    val id:String? = null,
    val alias:String? = null,
    val is_closed:Boolean = false,
    val categories:ArrayList<YelpCategoriesModel>? = null,
    val review_count:Int? = null,
    val name:String? = null,
    val url:String? = null,
    val coordinates: CoordinatesModel? = null,
    val image_url:String? = null,
    val location: BusinessAddressModel? = null,
    val distance:Float? = null,
    val transactions:List<String>? = null
) : Parcelable
