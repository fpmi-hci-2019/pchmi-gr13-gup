package com.gup.bookstore.ui.screens.booklist

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.navigation.findNavController
import com.gup.bookstore.BookStoreApp
import com.gup.bookstore.R
import com.gup.bookstore.ui.base.BaseActivity
import com.gup.bookstore.ui.screens.booklist.book.BookFragment
import com.gup.domain.exceptions.BookStoreException

class BookListActivity : BaseActivity<BookListViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booklist)
    }

    override fun onStart() {
        super.onStart()
        val bookFragmentArgs = BookFragment.createArgs(intent.getStringExtra(ID_KEY) ?: throw BookStoreException())
        findNavController(R.id.nav_host_fragment).setGraph(R.navigation.navigation_booklist, bookFragmentArgs)
    }

    override fun createViewModel() = BookStoreApp.instance.locator.createBookListViewModel()

    companion object {
        private const val ID_KEY = "ID_KEY"
        fun getIntent(context: Context?, id: String): Intent {
            return Intent(context, BookListActivity::class.java).apply {
                putExtra(ID_KEY, id)
            }
        }
    }
}