package com.gup.domain.usecases

import com.gup.domain.exceptions.BookStoreException
import com.gup.domain.repositories.OrderRepository
import com.gup.domain.repositories.ProfileRepository

class LoadOrderQuantityUsecaseImpl(
    private val profileRepository: ProfileRepository,
    private val orderRepository: OrderRepository
) : LoadOrderQuantityUsecase {
    override suspend fun execute(params: LoadOrderQuantityUsecase.Params): Int {
        val userId = profileRepository.loadUserId() ?: throw BookStoreException()
        return orderRepository.loadOrder(userId)?.size ?: 0
    }
}