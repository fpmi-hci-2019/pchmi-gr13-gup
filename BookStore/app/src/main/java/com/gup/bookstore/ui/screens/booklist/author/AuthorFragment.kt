package com.gup.bookstore.ui.screens.booklist.author

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import com.gup.bookstore.BookStoreApp
import com.gup.bookstore.R
import com.gup.bookstore.ui.base.BaseFragment
import com.gup.domain.entities.Author
import com.gup.domain.exceptions.BookStoreException
import kotlinx.android.synthetic.main.fragment_author.*

class AuthorFragment : BaseFragment<AuthorViewModel>() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_author, container, false)
    }

    override fun createViewModel(): AuthorViewModel {
        val authorId = requireArguments().getString(AUTHOR_ID_KEY) ?: throw BookStoreException()
        return BookStoreApp.instance.locator.createAuthorViewModel(authorId)
    }

    override fun bindViewModel() {
        super.bindViewModel()
        vm.author.observe(this, Observer { showAuthor(it) })
    }

    private fun showAuthor(author: Author) {
        nameView.text = author.name
        biographyView.text = author.biography
    }

    companion object {
        private const val AUTHOR_ID_KEY = "AUTHOR_ID_KEY"
        fun createArgs(authorId: String) = bundleOf(AUTHOR_ID_KEY to authorId)
    }
}