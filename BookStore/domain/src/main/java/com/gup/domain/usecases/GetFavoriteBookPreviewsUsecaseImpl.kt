package com.gup.domain.usecases

import com.gup.domain.entities.BookPreview
import com.gup.domain.exceptions.BookStoreException
import com.gup.domain.repositories.BooksRepository
import com.gup.domain.repositories.FavoritesRepository
import com.gup.domain.repositories.ProfileRepository

class GetFavoriteBookPreviewsUsecaseImpl(
    private val profileRepository: ProfileRepository,
    private val booksRepository: BooksRepository,
    private val favoritesRepository: FavoritesRepository
) : GetFavoriteBookPreviewsUsecase {
    override suspend fun execute(params: GetFavoriteBookPreviewsUsecase.Params): List<BookPreview> {
        val userId = profileRepository.loadUserId() ?: throw BookStoreException()
        val books = booksRepository.getBookPreviews()
        val favoritesIds = favoritesRepository.loadFavorites(userId)
        return if (favoritesIds != null) books.filter { favoritesIds.contains(it.id) } else emptyList()
    }
}