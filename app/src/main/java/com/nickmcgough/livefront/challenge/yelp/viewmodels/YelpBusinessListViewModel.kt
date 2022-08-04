package com.nickmcgough.livefront.challenge.yelp.viewmodels

import android.app.Application
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.android.volley.Response
import com.google.gson.Gson
import com.nickmcgough.livefront.challenge.ui.items
import com.nickmcgough.livefront.challenge.yelp.models.YelpBusinessInformationModel
import com.nickmcgough.livefront.challenge.yelp.models.YelpBusinessesBaseModel
import com.nickmcgough.livefront.challenge.yelp.repositories.YelpRepository
import com.nickmcgough.livefront.challenge.yelp.ui.YelpBusinessListEvent
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.json.JSONObject
import java.util.*
import kotlin.collections.ArrayList

const val STATE_KEY_LIST_POSITION = "business.list_position"

class YelpBusinessListViewModel
constructor(
    application: Application
) : AndroidViewModel(application) {
    var businesses: ArrayList<YelpBusinessInformationModel> = ArrayList()
    val loading = mutableStateOf(false)
    private val TAG = YelpBusinessListEvent::class.java.simpleName
    var listScrollPosition = 0

    fun onTriggerEvent(event: YelpBusinessListEvent){
        viewModelScope.launch {
            try {
                when(event){
                    is YelpBusinessListEvent -> {
                        newSearch()
                    }
                }
            }catch (e: Exception){
                Log.e(TAG, "launchJob: Exception: ${e}, ${e.cause}")
            }
            finally {
                Log.d(TAG, "launchJob: finally called.")
            }
        }
    }

    private fun setListPosition(position: Int){
        listScrollPosition = position
    }

    fun onChangeListScrollPosition(position: Int){
        setListPosition(position = position)
    }

    fun newSearch() {
        loading.value = true
        val parameters = TreeMap<String, String>()
        parameters["location"] = "Minneapolis,MN"
        parameters["term"] = "coffee"

        YelpRepository.getBusinessSearch(parameters, getApplication(), jsonResponseListener)
    }

    private val jsonResponseListener: Response.Listener<JSONObject>
        get() = Response.Listener { response ->
            items = Gson().fromJson(response.toString(), YelpBusinessesBaseModel::class.java)
            businesses = items?.businesses!!
            loading.value = false
        }
}