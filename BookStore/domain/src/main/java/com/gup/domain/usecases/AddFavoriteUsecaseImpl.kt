package com.gup.domain.usecases

import com.gup.domain.exceptions.BookStoreException
import com.gup.domain.repositories.FavoritesRepository
import com.gup.domain.repositories.ProfileRepository

class AddFavoriteUsecaseImpl(
    private val profileRepository: ProfileRepository,
    private val favoritesRepository: FavoritesRepository
) : AddFavoriteUsecase {
    override suspend fun execute(params: AddFavoriteUsecase.Params) {
        val userId = profileRepository.loadUserId() ?: throw BookStoreException()
        val favorites = (favoritesRepository.loadFavorites(userId) ?: emptySet()).toMutableSet()
        favorites.add(params.bookId)
        favoritesRepository.saveFavorites(userId, favorites)
    }
}