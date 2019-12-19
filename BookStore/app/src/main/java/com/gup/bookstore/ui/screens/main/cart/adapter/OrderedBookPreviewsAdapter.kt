package com.gup.bookstore.ui.screens.main.cart.adapter

import android.view.ViewGroup
import com.gup.bookstore.ui.base.adapter.BaseAdapter
import com.gup.domain.entities.BookPreview

class OrderedBookPreviewsAdapter(
    private val onTextClicked: (BookPreview) -> Unit,
    private val onRemoveClicked: (BookPreview) -> Unit
) : BaseAdapter<BookPreview, OrderedBookPreviewViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderedBookPreviewViewHolder {
        return OrderedBookPreviewViewHolder(parent, onTextClicked, onRemoveClicked)
    }
}