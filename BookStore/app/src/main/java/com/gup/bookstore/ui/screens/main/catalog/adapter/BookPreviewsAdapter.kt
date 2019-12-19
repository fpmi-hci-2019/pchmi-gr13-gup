package com.gup.bookstore.ui.screens.main.catalog.adapter

import android.view.ViewGroup
import com.gup.bookstore.ui.base.adapter.BaseAdapter
import com.gup.domain.entities.BookPreview

class BookPreviewsAdapter(private val onBookPreviewClicked: (BookPreview) -> Unit) :
    BaseAdapter<BookPreview, BookPreviewViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookPreviewViewHolder {
        return BookPreviewViewHolder(parent, onBookPreviewClicked)
    }
}