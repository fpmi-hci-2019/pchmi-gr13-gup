package com.gup.bookstore.ui.screens.main.catalog

import androidx.lifecycle.MutableLiveData
import com.gup.bookstore.ui.base.BaseViewModel
import com.gup.domain.entities.BookPreview
import com.gup.domain.usecases.GetBookPreviewsUsecase

class CatalogViewModel(private val getBookPreviewsUsecase: GetBookPreviewsUsecase) : BaseViewModel() {
    val bookPreviews = MutableLiveData<List<BookPreview>>()

    init {
        launchExplicitly {
            bookPreviews.value = getBookPreviewsUsecase.execute(GetBookPreviewsUsecase.Params())
        }
    }
}