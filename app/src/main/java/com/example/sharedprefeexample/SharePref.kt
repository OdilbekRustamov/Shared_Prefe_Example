package com.example.sharedprefeexample

import android.content.Context
import androidx.core.content.edit

class SharePref(context: Context) {
    private val pref = context.getSharedPreferences("nimadir", Context.MODE_PRIVATE)

    var isSaved: Boolean
    get() = pref.getBoolean("isSaved", false)
    set(value) = pref.edit { this.putBoolean("isSaved", value) }

//    fun isSaved(isSaved: Boolean){
//        val editor = pref.edit()
//        editor.putBoolean("isSaved", isSaved)
//        editor.apply()
//    }
//
//    fun getSaved(): Boolean{
//        return pref.getBoolean("isSaved", false)
//    }
}