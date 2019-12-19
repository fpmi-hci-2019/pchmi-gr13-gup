package com.gup.bookstore.ui.screens.booklist.author

import androidx.lifecycle.MutableLiveData
import com.gup.bookstore.ui.base.BaseViewModel
import com.gup.domain.entities.Author
import com.gup.domain.usecases.GetAuthorUsecase

class AuthorViewModel(
    private val authorId: String,
    private val getAuthorUsecase: GetAuthorUsecase
) : BaseViewModel() {
    val author = MutableLiveData<Author>()

    init {
        launchExplicitly {
            author.value = getAuthorUsecase.execute(GetAuthorUsecase.Params(authorId))
        }
    }
}