package com.gup.domain.repositories

interface FavoritesRepository {
    fun saveFavorites(userId: String, favoritesIds: Set<String>)
    fun loadFavorites(userId: String): Set<String>?
    fun eraseFavorites(userId: String)
}