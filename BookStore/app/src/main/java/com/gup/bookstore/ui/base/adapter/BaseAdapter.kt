package com.gup.bookstore.ui.base.adapter

import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T, VH : BaseViewHolder<T>> : RecyclerView.Adapter<VH>() {

    val items = mutableListOf<T>()

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: VH, position: Int) = holder.updateUI(items[position])
}