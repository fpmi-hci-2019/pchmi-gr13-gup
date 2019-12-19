package com.gup.domain.usecases

import com.gup.domain.entities.Book
import com.gup.domain.exceptions.BookStoreException
import com.gup.domain.repositories.BooksRepository
import com.gup.domain.repositories.FavoritesRepository
import com.gup.domain.repositories.ProfileRepository

class GetBookUsecaseImpl(
    private val profileRepository: ProfileRepository,
    private val booksRepository: BooksRepository,
    private val favoritesRepository: FavoritesRepository
) : GetBookUsecase {
    override suspend fun execute(params: GetBookUsecase.Params): Pair<Book, Boolean> {
        val userId = profileRepository.loadUserId() ?: throw BookStoreException()
        val book = booksRepository.getBook(params.id)
        val favoritesIds = favoritesRepository.loadFavorites(userId)
        val favorite = favoritesIds != null && favoritesIds.contains(book.id)
        return Pair(book, favorite)
    }
}