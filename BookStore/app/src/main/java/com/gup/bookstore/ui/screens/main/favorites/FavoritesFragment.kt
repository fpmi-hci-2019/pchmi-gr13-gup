package com.gup.bookstore.ui.screens.main.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gup.bookstore.BookStoreApp
import com.gup.bookstore.R
import com.gup.bookstore.ui.base.BaseFragment
import com.gup.bookstore.ui.screens.booklist.BookListActivity
import com.gup.bookstore.ui.screens.main.catalog.adapter.BookPreviewsAdapter
import com.gup.domain.entities.BookPreview
import kotlinx.android.synthetic.main.fragment_favorites.*

class FavoritesFragment : BaseFragment<FavoritesViewModel>() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(favoriteBookPreviewsView) {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = BookPreviewsAdapter { openBook(it.id) }
            addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
        }
    }

    override fun onResume() {
        super.onResume()
        vm.updateFavorites()
    }

    override fun createViewModel() = BookStoreApp.instance.locator.createFavoritesViewModel()

    override fun bindViewModel() {
        super.bindViewModel()
        vm.favoriteBookPreviews.observe(this, Observer { showBookPreviews(it) })
    }

    private fun openBook(id: String) {
        startActivity(BookListActivity.getIntent(context, id))
    }

    private fun showBookPreviews(booksPreviews: List<BookPreview>) {
        with(favoriteBookPreviewsView.adapter as BookPreviewsAdapter) {
            items.clear()
            items.addAll(booksPreviews)
            notifyDataSetChanged()
        }
    }
}