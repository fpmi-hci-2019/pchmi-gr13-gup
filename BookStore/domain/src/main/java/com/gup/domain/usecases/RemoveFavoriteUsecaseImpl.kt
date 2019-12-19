package com.gup.domain.usecases

import com.gup.domain.exceptions.BookStoreException
import com.gup.domain.repositories.FavoritesRepository
import com.gup.domain.repositories.ProfileRepository

class RemoveFavoriteUsecaseImpl(
    private val profileRepository: ProfileRepository,
    private val favoritesRepository: FavoritesRepository
) : RemoveFavoriteUsecase {
    override suspend fun execute(params: RemoveFavoriteUsecase.Params) {
        val userId = profileRepository.loadUserId() ?: throw BookStoreException()
        val favorites = (favoritesRepository.loadFavorites(userId) ?: emptySet()).toMutableSet()
        favorites.remove(params.bookId)
        favoritesRepository.saveFavorites(userId, favorites)
    }
}