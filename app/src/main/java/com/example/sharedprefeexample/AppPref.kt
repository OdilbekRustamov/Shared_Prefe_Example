package com.example.sharedprefeexample

import android.content.Context
import android.widget.Toast
import androidx.datastore.preferences.createDataStore
import androidx.datastore.preferences.edit
import androidx.datastore.preferences.preferencesKey
import kotlinx.coroutines.flow.map

class AppPref(context: Context) {
    private val detaStore = context.createDataStore(name = "nimadir")

    companion object{
        val USER_AGE_KEY = preferencesKey<Int>("USER_AGE")
        val USER_NAME_KEY = preferencesKey<String>("User_NAME")
    }
    suspend fun storeUser(age: Int, name: String){
        detaStore.edit {
            it[USER_AGE_KEY] = age
            it[USER_NAME_KEY] = name
        }
    }
    val userAge = detaStore.data.map {
        val age = it[USER_AGE_KEY] ?: 0
        if (age < 18){
            Toast.makeText(context, "Chekkaroqqa uyna", Toast.LENGTH_SHORT).show()
        }
        age
    }

    val userName = detaStore.data.map {
        it[USER_NAME_KEY] ?: ""
    }
}