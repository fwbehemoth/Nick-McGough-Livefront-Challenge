package com.nickmcgough.livefront.challenge.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BusinessAddressModel(
    val city:String? = null,
    val country:String? = null,
    val address1:String? = null,
    val address2:String? = null,
    val address3:String? = null,
    val state:String? = null,
    val zip_code:String? = null
) : Parcelable