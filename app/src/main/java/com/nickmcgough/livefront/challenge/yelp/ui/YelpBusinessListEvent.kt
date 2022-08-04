package com.nickmcgough.livefront.challenge.yelp.ui

sealed class YelpBusinessListEvent {
    object NewSearchEvent : YelpBusinessListEvent()
}