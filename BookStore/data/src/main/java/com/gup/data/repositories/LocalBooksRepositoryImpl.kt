package com.gup.data.repositories

import com.gup.domain.entities.*
import com.gup.domain.exceptions.BookStoreException
import com.gup.domain.repositories.BooksRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import java.math.BigDecimal

class LocalBooksRepositoryImpl : BooksRepository {
    override suspend fun getBookPreviews(): List<BookPreview> {
        return performActionWithDelay(500) {
            listOf(
                BookPreview(
                    "id0",
                    "Book0",
                    "Author0",
                    BigDecimal("0.00")
                ),
                BookPreview(
                    "id1",
                    "Book1",
                    "Author1",
                    BigDecimal("2.15")
                ),
                BookPreview(
                    "id2",
                    "Book2",
                    "Author2",
                    BigDecimal("45.35")
                ),
                BookPreview(
                    "id3",
                    "Book3",
                    "Author3",
                    BigDecimal("123.55")
                ),
                BookPreview(
                    "id4",
                    "Book4",
                    "Author4",
                    BigDecimal("10.05")
                ),
                BookPreview(
                    "id5",
                    "Book5",
                    "Author5",
                    BigDecimal("67.00")
                )
            )
        }
    }

    override suspend fun getBook(id: String): Book {
        return performActionWithDelay(500) {
            when (id) {
                "id0" -> Book(
                    "id0",
                    "Book0",
                    "authorId0",
                    "Author0",
                    "Description0",
                    "Genre0",
                    "publisherId0",
                    "Publisher0",
                    BigDecimal("0.00")
                )
                "id1" -> Book(
                    "id1",
                    "Book1",
                    "authorId1",
                    "Author1",
                    "Description1",
                    "Genre1",
                    "publisherId1",
                    "Publisher1",
                    BigDecimal("2.15")
                )
                "id2" -> Book(
                    "id2",
                    "Book2",
                    "authorId2",
                    "Author2",
                    "Description2",
                    "Genre2",
                    "publisherId2",
                    "Publisher2",
                    BigDecimal("45.35")
                )
                "id3" -> Book(
                    "id3",
                    "Book3",
                    "authorId3",
                    "Author3",
                    "Description3",
                    "Genre3",
                    "publisherId3",
                    "Publisher3",
                    BigDecimal("123.55")
                )
                "id4" -> Book(
                    "id4",
                    "Book4",
                    "authorId4",
                    "Author4",
                    "Description4",
                    "Genre4",
                    "publisherId4",
                    "Publisher4",
                    BigDecimal("10.05")
                )
                "id5" -> Book(
                    "id5",
                    "Book5",
                    "authorId5",
                    "Author5",
                    "Description5",
                    "Genre5",
                    "publisherId5",
                    "Publisher5",
                    BigDecimal("67.00")
                )
                else -> throw BookStoreException()
            }
        }
    }

    override suspend fun getAuthor(id: String): Author {
        return performActionWithDelay(500) {
            when (id) {
                "authorId0" -> Author(
                    "authorId0",
                    "Author0",
                    "Biography0"
                )
                "authorId1" -> Author(
                    "authorId1",
                    "Author1",
                    "Biography1"
                )
                "authorId2" -> Author(
                    "authorId2",
                    "Author2",
                    "Biography2"
                )
                "authorId3" -> Author(
                    "authorId3",
                    "Author3",
                    "Biography3"
                )
                "authorId4" -> Author(
                    "authorId4",
                    "Author4",
                    "Biography4"
                )
                "authorId5" -> Author(
                    "authorId5",
                    "Author5",
                    "Biography5"
                )
                else -> throw BookStoreException()
            }
        }
    }

    override suspend fun getPublisher(id: String): Publisher {
        return performActionWithDelay(500) {
            when (id) {
                "publisherId0" -> Publisher(
                    "publisherId0",
                    "Publisher0",
                    "PublisherDescription0",
                    "Address0"
                )
                "publisherId1" -> Publisher(
                    "publisherId1",
                    "Publisher1",
                    "PublisherDescription1",
                    "Address1"
                )
                "publisherId2" -> Publisher(
                    "publisherId2",
                    "Publisher2",
                    "PublisherDescription2",
                    "Address2"
                )
                "publisherId3" -> Publisher(
                    "publisherId3",
                    "Publisher3",
                    "PublisherDescription3",
                    "Address3"
                )
                "publisherId4" -> Publisher(
                    "publisherId4",
                    "Publisher4",
                    "PublisherDescription4",
                    "Address4"
                )
                "publisherId5" -> Publisher(
                    "publisherId5",
                    "Publisher5",
                    "PublisherDescription5",
                    "Address5"
                )
                else -> throw BookStoreException()
            }
        }
    }

    override suspend fun getNewsPreviews(): List<NewsPreview> {
        return performActionWithDelay(500) {
            listOf(
                NewsPreview(
                    "newsId0",
                    "newsText0",
                    "newsDate0",
                    "publisherId0"
                ),
                NewsPreview(
                    "newsId1",
                    "newsText1",
                    "newsDate1",
                    "publisherId1"
                ),
                NewsPreview(
                    "newsId2",
                    "newsText2",
                    "newsDate2",
                    "publisherId2"
                ),
                NewsPreview(
                    "newsId3",
                    "newsText3",
                    "newsDate3",
                    "publisherId3"
                ),
                NewsPreview(
                    "newsId4",
                    "newsText4",
                    "newsDate4",
                    "publisherId4"
                ),
                NewsPreview(
                    "newsId5",
                    "newsText5",
                    "newsDate5",
                    "publisherId5"
                )
            )
        }
    }

    override suspend fun getNews(id: String): News {
        return performActionWithDelay(500) {
            when (id) {
                "newsId0" -> News(
                    "newsId0",
                    "newsTitle0",
                    "newsLongText0",
                    "newsDate0",
                    "publisherId0",
                    "Publisher0"
                )
                "newsId1" -> News(
                    "newsId1",
                    "newsTitle1",
                    "newsLongText1",
                    "newsDate1",
                    "publisherId1",
                    "Publisher1"
                )
                "newsId2" -> News(
                    "newsId2",
                    "newsTitle2",
                    "newsLongText2",
                    "newsDate2",
                    "publisherId2",
                    "Publisher2"
                )
                "newsId3" -> News(
                    "newsId3",
                    "newsTitle3",
                    "newsLongText3",
                    "newsDate3",
                    "publisherId3",
                    "Publisher3"
                )
                "newsId4" -> News(
                    "newsId4",
                    "newsTitle4",
                    "newsLongText4",
                    "newsDate4",
                    "publisherId4",
                    "Publisher4"
                )
                "newsId5" -> News(
                    "newsId5",
                    "newsTitle5",
                    "newsLongText5",
                    "newsDate5",
                    "publisherId5",
                    "Publisher5"
                )
                else -> throw BookStoreException()
            }
        }
    }

    private suspend fun <T> performActionWithDelay(millis: Long, action: () -> T): T {
        return withContext(Dispatchers.IO) {
            delay(millis)
            action()
        }
    }
}