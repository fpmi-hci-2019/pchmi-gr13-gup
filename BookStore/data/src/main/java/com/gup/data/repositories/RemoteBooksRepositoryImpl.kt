package com.gup.data.repositories

import com.google.firebase.firestore.FirebaseFirestore
import com.gup.domain.entities.*
import com.gup.domain.exceptions.BackendException
import com.gup.domain.repositories.BooksRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class RemoteBooksRepositoryImpl(private val firestore: FirebaseFirestore) : BooksRepository {
    override suspend fun getBookPreviews(): List<BookPreview> {
        return performIOAction {
            firestore.collection("BookPreviews")
                .get()
                .await()
                .toObjects(BookPreview::class.java)
        }
    }

    override suspend fun getBook(id: String): Book {
        return performIOAction {
            firestore.collection("Books")
                .document(id)
                .get()
                .await()
                ?.toObject(Book::class.java) ?: throw BackendException()
        }
    }

    override suspend fun getAuthor(id: String): Author {
        return performIOAction {
            firestore.collection("Authors")
                .document(id)
                .get()
                .await()
                ?.toObject(Author::class.java) ?: throw BackendException()
        }
    }

    override suspend fun getPublisher(id: String): Publisher {
        return performIOAction {
            firestore.collection("Publishers")
                .document(id)
                .get()
                .await()
                ?.toObject(Publisher::class.java) ?: throw BackendException()
        }
    }

    override suspend fun getNewsPreviews(): List<NewsPreview> {
        return performIOAction {
            firestore.collection("NewsPreviews")
                .get()
                .await()
                .toObjects(NewsPreview::class.java)
        }
    }

    override suspend fun getNews(id: String): News {
        return performIOAction {
            firestore.collection("News")
                .document(id)
                .get()
                .await()
                ?.toObject(News::class.java) ?: throw BackendException()
        }
    }

    private suspend fun <T> performIOAction(action: suspend () -> T): T {
        return withContext(Dispatchers.IO) {
            action()
        }
    }
}