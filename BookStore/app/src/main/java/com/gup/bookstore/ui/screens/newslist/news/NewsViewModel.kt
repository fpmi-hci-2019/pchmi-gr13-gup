package com.gup.bookstore.ui.screens.newslist.news

import androidx.lifecycle.MutableLiveData
import com.gup.bookstore.ui.base.BaseViewModel
import com.gup.domain.entities.News
import com.gup.domain.usecases.GetNewsUsecase

class NewsViewModel(
    private val newsId: String,
    private val getNewsUsecase: GetNewsUsecase
) : BaseViewModel() {
    val news = MutableLiveData<News>()

    init {
        launchExplicitly {
            news.value = getNewsUsecase.execute(GetNewsUsecase.Params(newsId))
        }
    }
}