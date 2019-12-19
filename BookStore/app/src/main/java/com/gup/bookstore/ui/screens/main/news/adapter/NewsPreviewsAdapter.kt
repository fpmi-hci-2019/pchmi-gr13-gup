package com.gup.bookstore.ui.screens.main.news.adapter

import android.view.ViewGroup
import com.gup.bookstore.ui.base.adapter.BaseAdapter
import com.gup.domain.entities.NewsPreview

class NewsPreviewsAdapter(private val onNewsPreviewClicked: (NewsPreview) -> Unit) :
    BaseAdapter<NewsPreview, NewsPreviewViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsPreviewViewHolder {
        return NewsPreviewViewHolder(parent, onNewsPreviewClicked)
    }
}