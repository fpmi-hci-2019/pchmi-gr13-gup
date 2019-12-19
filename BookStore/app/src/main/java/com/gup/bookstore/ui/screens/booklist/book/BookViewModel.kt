package com.gup.bookstore.ui.screens.booklist.book

import androidx.lifecycle.MutableLiveData
import com.gup.bookstore.ui.base.BaseViewModel
import com.gup.domain.entities.Book
import com.gup.domain.usecases.AddBookToOrderUsecase
import com.gup.domain.usecases.AddFavoriteUsecase
import com.gup.domain.usecases.GetBookUsecase
import com.gup.domain.usecases.RemoveFavoriteUsecase

class BookViewModel(
    private val bookId: String,
    private val getBookUsecase: GetBookUsecase,
    private val addFavoriteUsecase: AddFavoriteUsecase,
    private val removeFavoriteUsecase: RemoveFavoriteUsecase,
    private val addBookToOrderUsecase: AddBookToOrderUsecase
) : BaseViewModel() {
    val book = MutableLiveData<Book>()
    val favorite = MutableLiveData<Boolean>()

    init {
        launchExplicitly {
            val getBookResult = getBookUsecase.execute(GetBookUsecase.Params(bookId))
            book.value = getBookResult.first
            favorite.value = getBookResult.second
        }
    }

    fun changeFavorite() {
        launchExplicitly {
            if (favorite.value == true) {
                favorite.value = false
                removeFavoriteUsecase.execute(RemoveFavoriteUsecase.Params(bookId))
            } else {
                favorite.value = true
                addFavoriteUsecase.execute(AddFavoriteUsecase.Params(bookId))
            }
        }
    }

    fun addToCart() {
        launchExplicitly {
            addBookToOrderUsecase.execute(AddBookToOrderUsecase.Params(bookId))
        }
    }
}