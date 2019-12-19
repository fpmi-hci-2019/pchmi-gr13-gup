package com.gup.bookstore.ui.screens.main.news

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
import com.gup.bookstore.ui.screens.main.news.adapter.NewsPreviewsAdapter
import com.gup.bookstore.ui.screens.newslist.NewsListActivity
import com.gup.domain.entities.NewsPreview
import kotlinx.android.synthetic.main.fragment_news_list.*

class NewsListFragment : BaseFragment<NewsListFragmentViewModel>() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_news_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(newsPreviewsView) {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = NewsPreviewsAdapter { openNews(it.id) }
            addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
        }
    }

    override fun onResume() {
        super.onResume()
        vm.updateNews()
    }

    override fun createViewModel() = BookStoreApp.instance.locator.createNewsListFragmentViewModel()

    override fun bindViewModel() {
        super.bindViewModel()
        vm.newsPreviews.observe(this, Observer { showNewsPreviews(it) })
    }

    private fun openNews(id: String) {
        startActivity(NewsListActivity.getIntent(context, id))
    }

    private fun showNewsPreviews(newsPreviews: List<NewsPreview>) {
        with(newsPreviewsView.adapter as NewsPreviewsAdapter) {
            items.clear()
            items.addAll(newsPreviews)
            notifyDataSetChanged()
        }
    }
}