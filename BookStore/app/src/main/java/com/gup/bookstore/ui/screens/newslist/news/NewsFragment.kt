package com.gup.bookstore.ui.screens.newslist.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.gup.bookstore.BookStoreApp
import com.gup.bookstore.R
import com.gup.bookstore.ui.base.BaseFragment
import com.gup.bookstore.ui.screens.publisher.PublisherFragment
import com.gup.domain.entities.News
import com.gup.domain.exceptions.BookStoreException
import kotlinx.android.synthetic.main.fragment_news.*

class NewsFragment : BaseFragment<NewsViewModel>() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun createViewModel(): NewsViewModel {
        val newsId = requireArguments().getString(NEWS_ID_KEY) ?: throw BookStoreException()
        return BookStoreApp.instance.locator.createNewsViewModel(newsId)
    }

    override fun bindViewModel() {
        super.bindViewModel()
        vm.news.observe(this, Observer { showNews(it) })
    }

    private fun showNews(news: News) {
        newsTitleView.text = news.title
        newsTextView.text = news.text
        publisherView.text = resources.getString(R.string.news_publisher_format).format(news.date, news.publisherName)
        publisherView.setOnClickListener { openPublisher(news.publisherId) }
    }

    private fun openPublisher(id: String) {
        findNavController().navigate(R.id.publisherScreen, PublisherFragment.createArgs(id))
    }

    companion object {
        private const val NEWS_ID_KEY = "NEWS_ID_KEY"
        fun createArgs(newsId: String) = bundleOf(NEWS_ID_KEY to newsId)
    }
}