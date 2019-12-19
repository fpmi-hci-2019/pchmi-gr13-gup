package com.gup.domain.repositories

import com.gup.domain.entities.*

interface BooksRepository {
    suspend fun getBookPreviews(): List<BookPreview>
    suspend fun getBook(id: String): Book
    suspend fun getAuthor(id: String): Author
    suspend fun getPublisher(id: String): Publisher
    suspend fun getNewsPreviews(): List<NewsPreview>
    suspend fun getNews(id: String): News
}