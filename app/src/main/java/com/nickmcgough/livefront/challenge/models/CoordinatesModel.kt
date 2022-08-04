package com.nickmcgough.livefront.challenge.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CoordinatesModel(
    val latitude:Float? = null,
    val longitude:Float? = null
) : Parcelable