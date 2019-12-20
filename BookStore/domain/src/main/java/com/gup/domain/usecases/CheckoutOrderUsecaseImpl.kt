package com.gup.domain.usecases

import com.gup.domain.exceptions.BookStoreException
import com.gup.domain.repositories.OrderRepository
import com.gup.domain.repositories.ProfileRepository

class CheckoutOrderUsecaseImpl(
    private val profileRepository: ProfileRepository,
    private val orderRepository: OrderRepository
) : CheckoutOrderUsecase {
    override suspend fun execute(params: CheckoutOrderUsecase.Params) {
        val userId = profileRepository.loadUserId() ?: throw BookStoreException()
        orderRepository.eraseOrder(userId)
    }
}