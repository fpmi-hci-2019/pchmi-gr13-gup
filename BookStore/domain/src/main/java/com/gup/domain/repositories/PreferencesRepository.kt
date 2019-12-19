package com.gup.domain.repositories

interface PreferencesRepository {
    fun saveString(key: String, value: String)
    fun loadString(key: String): String?
    fun saveStringSet(key: String, value: Set<String>)
    fun loadStringSet(key: String): Set<String>?
    fun saveInt(key: String, value: Int)
    fun loadInt(key: String): Int?
    fun saveBoolean(key: String, value: Boolean)
    fun loadBoolean(key: String): Boolean?
    fun eraseValue(key: String)
}