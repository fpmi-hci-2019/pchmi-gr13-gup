package com.gup.bookstore.ui.screens.newslist

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.navigation.findNavController
import com.gup.bookstore.BookStoreApp
import com.gup.bookstore.R
import com.gup.bookstore.ui.base.BaseActivity
import com.gup.bookstore.ui.screens.newslist.news.NewsFragment
import com.gup.domain.exceptions.BookStoreException

class NewsListActivity : BaseActivity<NewsListActivityViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newslist)
    }

    override fun onStart() {
        super.onStart()
        val newsFragmentArgs = NewsFragment.createArgs(intent.getStringExtra(ID_KEY) ?: throw BookStoreException())
        findNavController(R.id.nav_host_fragment).setGraph(R.navigation.navigation_newslist, newsFragmentArgs)
    }

    override fun createViewModel() = BookStoreApp.instance.locator.createNewsListActivityViewModel()

    companion object {
        private const val ID_KEY = "ID_KEY"
        fun getIntent(context: Context?, id: String): Intent {
            return Intent(context, NewsListActivity::class.java).apply {
                putExtra(ID_KEY, id)
            }
        }
    }
}