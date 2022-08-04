package com.nickmcgough.livefront.challenge.yelp.repositories

import android.content.Context
import android.util.Log
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.nickmcgough.livefront.challenge.LivefrontApplication
import com.nickmcgough.livefront.challenge.utils.RepositoryUtils
import org.json.JSONObject
import java.util.*

object YelpRepository {
    private val TAG = YelpRepository::class.java.simpleName
    private const val BASE_URL = "https://api.yelp.com/v3/"
    private const val API_KEY = "DfB7fwO0cxeh4_kvrA0LJq4B3bLNNbZUkBk1xFOu9O31cytlE0RJ7nc3_qWEFk6HxUT2PuhYk" +
            "ARrOLJ0CUTzLu1ug33cVo6tDazJ3_9zY5HTdRFAU_Ci_46BK4_qYnYx"

    fun getBusinessSearch(searchParameters:TreeMap<String,String>,
                          context: Context,
                          responseListener: Response.Listener<JSONObject> = jsonResponseListener,
                          errorListener: Response.ErrorListener = YelpRepository.errorListener
    ){
        var url = buildString {
            append(BASE_URL)
            append("businesses/search")
        }

        url = RepositoryUtils.appendParametersToUrl(url, searchParameters)

        val queue = Volley.newRequestQueue(context)
        val jsonObjectRequest = object : JsonObjectRequest(url, responseListener, errorListener){
            @Throws(AuthFailureError::class)
            override fun getHeaders() : Map<String,String> {
                var headers = super.getHeaders().toMutableMap()
                if (headers == null) headers = HashMap<String, String>()
                    headers.put("Authorization", "Bearer $API_KEY")

                return headers
            }
        }

        queue.add(jsonObjectRequest)
    }

    private val jsonResponseListener: Response.Listener<JSONObject>
        get() = Response.Listener { response -> Log.d(TAG, "Response: $response") }

    private val errorListener: Response.ErrorListener
        get() = Response.ErrorListener { error -> Log.d(TAG, "Error: " + error.localizedMessage) }
}