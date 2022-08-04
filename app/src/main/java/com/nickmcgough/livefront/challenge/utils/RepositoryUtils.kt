package com.nickmcgough.livefront.challenge.utils

import java.net.URLEncoder
import java.util.*

object RepositoryUtils {

    fun appendParametersToUrl(url:String, searchParameters: TreeMap<String, String>) : String{
        var returnString = ""

        if(!searchParameters.isEmpty()) {
            returnString = buildString {
                append(url)
                if (!searchParameters.isEmpty())
                    append("?")

                searchParameters.forEach { parameter ->
                    append(parameter.key)
                    append("=")
                    append(parameter.value)
                    if (parameter != searchParameters.lastEntry())
                        append("&")
                }
            }
        }

        return returnString
    }
}