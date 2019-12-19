package com.gup.domain.usecases

import com.gup.domain.exceptions.BookStoreException
import com.gup.domain.repositories.FavoritesRepository
import com.gup.domain.repositories.OrderRepository
import com.gup.domain.repositories.ProfileRepository
import com.gup.domain.repositories.SubscriptionsRepository

class LogoutUsecaseImpl(
    private val profileRepository: ProfileRepository,
    private val favoritesRepository: FavoritesRepository,
    private val orderRepository: OrderRepository,
    private val subscriptionsRepository: SubscriptionsRepository
) : LogoutUsecase {
    override suspend fun execute(params: LogoutUsecase.Params) {
        val userId = profileRepository.loadUserId() ?: throw BookStoreException()
        favoritesRepository.eraseFavorites(userId)
        orderRepository.eraseOrder(userId)
        subscriptionsRepository.eraseSubscriptions(userId)
        profileRepository.eraseUserId()
    }
}