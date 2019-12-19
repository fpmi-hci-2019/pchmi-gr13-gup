package com.gup.bookstore.ui.screens.main.news.adapter

import android.view.ViewGroup
import com.gup.bookstore.R
import com.gup.bookstore.ui.base.adapter.BaseViewHolder
import com.gup.bookstore.ui.extensions.inflate
import com.gup.domain.entities.NewsPreview
import kotlinx.android.synthetic.main.item_news_preview.view.*

class NewsPreviewViewHolder(parent: ViewGroup, private val onClicked: (NewsPreview) -> Unit) :
    BaseViewHolder<NewsPreview>(parent.inflate(R.layout.item_news_preview)) {

    override fun updateUI(item: NewsPreview) {
        with(root) {
            newsTextView.text = item.text
            newsDateView.text = item.date
            setOnClickListener { onClicked(item) }
        }
    }
}