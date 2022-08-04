package com.nickmcgough.livefront.challenge.utils

import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotSame
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.util.*

@RunWith(JUnit4::class)
internal class RepositoryUtilsTest{
    val baseUrl = "https://livefront.com/"
    val parameters = TreeMap<String, String>()

    @Test
    fun validUrlReturn(){
        parameters.clear()
        parameters["location"] = "Home"
        parameters["term"] = "Base"
        val result = RepositoryUtils.appendParametersToUrl(baseUrl, parameters)
        assertEquals(result, "https://livefront.com/?location=Home&term=Base")
    }

    @Test
    fun inValidUrlReturn(){
        parameters.clear()
        parameters["location"] = "Home"
        parameters["term"] = "Base"
        val result = RepositoryUtils.appendParametersToUrl(baseUrl, parameters)
        assertNotSame(result, "https://livefront.com/?location=Base&term=Home")
    }
}