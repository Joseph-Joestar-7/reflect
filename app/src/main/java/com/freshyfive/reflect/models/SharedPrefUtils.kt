package com.freshyfive.reflect.models

import android.content.Context
import android.content.SharedPreferences

fun saveUserData(context: Context, name: String, gender: String, profession: String) {
    val sharedPreferences: SharedPreferences = context.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putString("userName", name)
    editor.putString("userGender", gender)
    editor.putString("userProfession", profession)
    editor.apply()
}

fun saveMood(context: Context,mood:String)
{
    val sharedPreferences: SharedPreferences = context.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putString("userMood",mood)
    editor.apply()
}

fun getUserName(context: Context): String? {
    val sharedPreferences: SharedPreferences = context.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
    return sharedPreferences.getString("userName", null)
}

fun isMoodAvailable(context: Context):Boolean{
    val sharedPreferences = context.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
    return sharedPreferences.contains("userMood")
}

fun isUserDataAvailable(context: Context): Boolean {
    val sharedPreferences: SharedPreferences = context.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
    return sharedPreferences.contains("userName") &&
            sharedPreferences.contains("userGender") &&
            sharedPreferences.contains("userProfession")
}