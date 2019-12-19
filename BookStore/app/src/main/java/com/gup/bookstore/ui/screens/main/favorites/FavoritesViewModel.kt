package com.gup.bookstore.ui.screens.main.favorites

import androidx.lifecycle.MutableLiveData
import com.gup.bookstore.ui.base.BaseViewModel
import com.gup.domain.entities.BookPreview
import com.gup.domain.usecases.GetFavoriteBookPreviewsUsecase

class FavoritesViewModel(private val getFavoriteBookPreviewsUsecase: GetFavoriteBookPreviewsUsecase) : BaseViewModel() {
    val favoriteBookPreviews = MutableLiveData<List<BookPreview>>()

    fun updateFavorites() {
        launchExplicitly {
            favoriteBookPreviews.value = getFavoriteBookPreviewsUsecase.execute(GetFavoriteBookPreviewsUsecase.Params())
        }
    }
}