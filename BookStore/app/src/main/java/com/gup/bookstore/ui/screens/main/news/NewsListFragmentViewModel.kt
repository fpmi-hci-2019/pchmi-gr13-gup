package com.gup.bookstore.ui.screens.main.news

import androidx.lifecycle.MutableLiveData
import com.gup.bookstore.ui.base.BaseViewModel
import com.gup.domain.entities.NewsPreview
import com.gup.domain.usecases.GetNewsPreviewsUsecase

class NewsListFragmentViewModel(private val getNewsPreviewsUsecase: GetNewsPreviewsUsecase) : BaseViewModel() {
    val newsPreviews = MutableLiveData<List<NewsPreview>>()

    fun updateNews() {
        launchExplicitly {
            newsPreviews.value = getNewsPreviewsUsecase.execute(GetNewsPreviewsUsecase.Params())
        }
    }
}