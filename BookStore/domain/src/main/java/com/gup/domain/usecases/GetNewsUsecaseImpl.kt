package com.gup.domain.usecases

import com.gup.domain.entities.News
import com.gup.domain.repositories.BooksRepository

class GetNewsUsecaseImpl(
    private val booksRepository: BooksRepository
) : GetNewsUsecase {
    override suspend fun execute(params: GetNewsUsecase.Params): News {
        return booksRepository.getNews(params.id)
    }
}