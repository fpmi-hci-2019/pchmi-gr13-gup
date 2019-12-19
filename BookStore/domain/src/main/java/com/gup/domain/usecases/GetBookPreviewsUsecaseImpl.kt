package com.gup.domain.usecases

import com.gup.domain.entities.BookPreview
import com.gup.domain.repositories.BooksRepository

class GetBookPreviewsUsecaseImpl(private val booksRepository: BooksRepository) : GetBookPreviewsUsecase {
    override suspend fun execute(params: GetBookPreviewsUsecase.Params): List<BookPreview> {
        return booksRepository.getBookPreviews()
    }
}