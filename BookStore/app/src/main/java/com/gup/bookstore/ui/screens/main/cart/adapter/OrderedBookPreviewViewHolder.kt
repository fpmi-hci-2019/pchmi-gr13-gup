package com.gup.bookstore.ui.screens.main.cart.adapter

import android.view.ViewGroup
import com.gup.bookstore.R
import com.gup.bookstore.ui.base.adapter.BaseViewHolder
import com.gup.bookstore.ui.extensions.inflate
import com.gup.domain.entities.BookPreview
import kotlinx.android.synthetic.main.item_ordered_book_preview.view.*

class OrderedBookPreviewViewHolder(
    parent: ViewGroup,
    private val onTextClicked: (BookPreview) -> Unit,
    private val onRemoveClicked: (BookPreview) -> Unit
) : BaseViewHolder<BookPreview>(parent.inflate(R.layout.item_ordered_book_preview)) {

    override fun updateUI(item: BookPreview) {
        with(root) {
            nameView.text = resources.getString(R.string.book_name_format).format(item.name, item.author)
            priceView.text = resources.getString(R.string.price_format).format(item.price)
            textContainerView.setOnClickListener { onTextClicked(item) }
            removeButton.setOnClickListener { onRemoveClicked(item) }
        }
    }
}