package com.gup.domain.usecases

import com.gup.domain.exceptions.BookStoreException
import com.gup.domain.repositories.OrderRepository
import com.gup.domain.repositories.ProfileRepository

class RemoveBookFromOrderUsecaseImpl(
    private val profileRepository: ProfileRepository,
    private val orderRepository: OrderRepository
) : RemoveBookFromOrderUsecase {
    override suspend fun execute(params: RemoveBookFromOrderUsecase.Params) {
        val userId = profileRepository.loadUserId() ?: throw BookStoreException()
        val order = (orderRepository.loadOrder(userId) ?: emptySet()).toMutableSet()
        order.remove(params.bookId)
        orderRepository.saveOrder(userId, order)
    }
}