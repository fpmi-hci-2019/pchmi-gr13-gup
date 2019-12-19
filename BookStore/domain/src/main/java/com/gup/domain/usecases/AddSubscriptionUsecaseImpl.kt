package com.gup.domain.usecases

import com.gup.domain.exceptions.BookStoreException
import com.gup.domain.repositories.ProfileRepository
import com.gup.domain.repositories.SubscriptionsRepository

class AddSubscriptionUsecaseImpl(
    private val profileRepository: ProfileRepository,
    private val subscriptionsRepository: SubscriptionsRepository
) : AddSubscriptionUsecase {
    override suspend fun execute(params: AddSubscriptionUsecase.Params) {
        val userId = profileRepository.loadUserId() ?: throw BookStoreException()
        val subscriptions = (subscriptionsRepository.loadSubscriptions(userId) ?: emptySet()).toMutableSet()
        subscriptions.add(params.publisherId)
        subscriptionsRepository.saveSubscriptions(userId, subscriptions)
    }
}