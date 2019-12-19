package com.gup.domain.usecases

import com.gup.domain.entities.BookPreview
import com.gup.domain.exceptions.BookStoreException
import com.gup.domain.repositories.BooksRepository
import com.gup.domain.repositories.OrderRepository
import com.gup.domain.repositories.ProfileRepository

class LoadOrderUsecaseImpl(
    private val profileRepository: ProfileRepository,
    private val booksRepository: BooksRepository,
    private val orderRepository: OrderRepository
) : LoadOrderUsecase {
    override suspend fun execute(params: LoadOrderUsecase.Params): List<BookPreview> {
        val userId = profileRepository.loadUserId() ?: throw BookStoreException()
        val bookPreviews = booksRepository.getBookPreviews()
        val orderedBooksIds = orderRepository.loadOrder(userId) ?: emptySet()
        return bookPreviews.filter { orderedBooksIds.contains(it.id) }
    }
}