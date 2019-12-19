package com.gup.domain.usecases

import com.gup.domain.entities.Author
import com.gup.domain.repositories.BooksRepository

class GetAuthorUsecaseImpl(private val booksRepository: BooksRepository) : GetAuthorUsecase {
    override suspend fun execute(params: GetAuthorUsecase.Params): Author {
        return booksRepository.getAuthor(params.id)
    }
}