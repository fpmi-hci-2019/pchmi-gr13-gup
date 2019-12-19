package com.gup.data.extensions

import android.annotation.SuppressLint
import android.content.SharedPreferences

@SuppressLint("ApplySharedPref")
fun SharedPreferences.saveString(key: String, value: String) {
    edit().putString(key, value).commit()
}

fun SharedPreferences.loadString(key: String): String? {
    return getString(key, null)
}

@SuppressLint("ApplySharedPref")
fun SharedPreferences.saveStringSet(key: String, value: Set<String>) {
    edit().putStringSet(key, value).commit()
}

fun SharedPreferences.loadStringSet(key: String): Set<String>? {
    return getStringSet(key, null)
}

@SuppressLint("ApplySharedPref")
fun SharedPreferences.saveInt(key: String, value: Int) {
    edit().putInt(key, value).commit()
}

fun SharedPreferences.loadInt(key: String): Int? {
    return if (contains(key)) {
        getInt(key, 0)
    } else {
        null
    }
}

@SuppressLint("ApplySharedPref")
fun SharedPreferences.saveBoolean(key: String, value: Boolean) {
    edit().putBoolean(key, value).commit()
}

fun SharedPreferences.loadBoolean(key: String): Boolean? {
    return if (contains(key)) {
        getBoolean(key, false)
    } else {
        null
    }
}

@SuppressLint("ApplySharedPref")
fun SharedPreferences.erase(key: String) {
    edit().remove(key).commit()
}