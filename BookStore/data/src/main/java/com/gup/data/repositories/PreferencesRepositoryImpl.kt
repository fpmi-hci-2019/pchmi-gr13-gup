package com.gup.data.repositories

import android.content.SharedPreferences
import com.gup.data.extensions.*
import com.gup.domain.repositories.PreferencesRepository

class PreferencesRepositoryImpl(private val preferences: SharedPreferences) : PreferencesRepository {
    override fun saveString(key: String, value: String) = preferences.saveString(key, value)

    override fun loadString(key: String) = preferences.loadString(key)

    override fun saveStringSet(key: String, value: Set<String>) = preferences.saveStringSet(key, value)

    override fun loadStringSet(key: String) = preferences.loadStringSet(key)

    override fun saveInt(key: String, value: Int) = preferences.saveInt(key, value)

    override fun loadInt(key: String) = preferences.loadInt(key)

    override fun saveBoolean(key: String, value: Boolean) = preferences.saveBoolean(key, value)

    override fun loadBoolean(key: String) = preferences.loadBoolean(key)

    override fun eraseValue(key: String) = preferences.erase(key)
}