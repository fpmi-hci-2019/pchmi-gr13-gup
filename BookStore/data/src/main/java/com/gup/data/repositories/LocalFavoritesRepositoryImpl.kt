package com.gup.data.repositories

import com.gup.domain.repositories.FavoritesRepository
import com.gup.domain.repositories.PreferencesRepository

class LocalFavoritesRepositoryImpl(private val preferencesRepository: PreferencesRepository) : FavoritesRepository {
    override fun saveFavorites(userId: String, favoritesIds: Set<String>) {
        preferencesRepository.saveStringSet(userId, favoritesIds)
    }

    override fun loadFavorites(userId: String): Set<String>? {
        return preferencesRepository.loadStringSet(userId)
    }

    override fun eraseFavorites(userId: String) {
        preferencesRepository.eraseValue(userId)
    }

    companion object {
        const val PREFS_FAVORITES_NAME = "PREFS_FAVORITES_NAME"
    }
}