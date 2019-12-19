package com.gup.bookstore.ui.base.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(protected val root: View) : RecyclerView.ViewHolder(root) {
    abstract fun updateUI(item: T)
}