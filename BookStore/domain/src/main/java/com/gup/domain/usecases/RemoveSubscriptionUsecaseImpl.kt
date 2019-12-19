package com.gup.domain.usecases

import com.gup.domain.exceptions.BookStoreException
import com.gup.domain.repositories.ProfileRepository
import com.gup.domain.repositories.SubscriptionsRepository

class RemoveSubscriptionUsecaseImpl(
    private val profileRepository: ProfileRepository,
    private val subscriptionsRepository: SubscriptionsRepository
) : RemoveSubscriptionUsecase {
    override suspend fun execute(params: RemoveSubscriptionUsecase.Params) {
        val userId = profileRepository.loadUserId() ?: throw BookStoreException()
        val subscriptions = (subscriptionsRepository.loadSubscriptions(userId) ?: emptySet()).toMutableSet()
        subscriptions.remove(params.publisherId)
        subscriptionsRepository.saveSubscriptions(userId, subscriptions)
    }
}