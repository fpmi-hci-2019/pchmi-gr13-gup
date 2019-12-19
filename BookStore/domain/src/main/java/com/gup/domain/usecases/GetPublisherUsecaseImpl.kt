package com.gup.domain.usecases

import com.gup.domain.entities.Publisher
import com.gup.domain.exceptions.BookStoreException
import com.gup.domain.repositories.BooksRepository
import com.gup.domain.repositories.ProfileRepository
import com.gup.domain.repositories.SubscriptionsRepository

class GetPublisherUsecaseImpl(
    private val profileRepository: ProfileRepository,
    private val booksRepository: BooksRepository,
    private val subscriptionsRepository: SubscriptionsRepository
) : GetPublisherUsecase {
    override suspend fun execute(params: GetPublisherUsecase.Params): Pair<Publisher, Boolean> {
        val userId = profileRepository.loadUserId() ?: throw BookStoreException()
        val publisher = booksRepository.getPublisher(params.id)
        val subscriptions = subscriptionsRepository.loadSubscriptions(userId)
        val subscribed = subscriptions != null && subscriptions.contains(publisher.id)
        return Pair(publisher, subscribed)
    }
}