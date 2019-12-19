package com.gup.domain.usecases

import com.gup.domain.exceptions.BookStoreException
import com.gup.domain.repositories.OrderRepository
import com.gup.domain.repositories.ProfileRepository

class AddBookToOrderUsecaseImpl(
    private val profileRepository: ProfileRepository,
    private val orderRepository: OrderRepository
) : AddBookToOrderUsecase {
    override suspend fun execute(params: AddBookToOrderUsecase.Params) {
        val userId = profileRepository.loadUserId() ?: throw BookStoreException()
        val order = (orderRepository.loadOrder(userId) ?: emptySet()).toMutableSet()
        order.add(params.bookId)
        orderRepository.saveOrder(userId, order)
    }
}