package com.freshyfive.reflect.data
import java.io.Serializable

data class Article(
    val articleName:String,
    val articleText:String
): Serializable
