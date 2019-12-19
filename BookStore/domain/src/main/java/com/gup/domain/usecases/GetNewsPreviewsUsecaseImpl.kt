package com.gup.domain.usecases

import com.gup.domain.entities.NewsPreview
import com.gup.domain.exceptions.BookStoreException
import com.gup.domain.repositories.BooksRepository
import com.gup.domain.repositories.ProfileRepository
import com.gup.domain.repositories.SubscriptionsRepository

class GetNewsPreviewsUsecaseImpl(
    private val profileRepository: ProfileRepository,
    private val booksRepository: BooksRepository,
    private val subscriptionsRepository: SubscriptionsRepository
) : GetNewsPreviewsUsecase {
    override suspend fun execute(params: GetNewsPreviewsUsecase.Params): List<NewsPreview> {
        val userId = profileRepository.loadUserId() ?: throw BookStoreException()
        val newsPreviews = booksRepository.getNewsPreviews()
        val publisherIds = subscriptionsRepository.loadSubscriptions(userId)
        return if (publisherIds != null) newsPreviews.filter { publisherIds.contains(it.publisherId) } else emptyList()
    }
}