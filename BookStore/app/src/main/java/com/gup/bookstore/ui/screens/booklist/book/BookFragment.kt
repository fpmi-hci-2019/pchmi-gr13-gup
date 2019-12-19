package com.gup.bookstore.ui.screens.booklist.book

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
import com.gup.bookstore.ui.screens.booklist.author.AuthorFragment
import com.gup.bookstore.ui.screens.publisher.PublisherFragment
import com.gup.domain.entities.Book
import com.gup.domain.exceptions.BookStoreException
import kotlinx.android.synthetic.main.fragment_book.*

class BookFragment : BaseFragment<BookViewModel>() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_book, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        favoriteView.setOnClickListener { vm.changeFavorite() }
        cartView.setOnClickListener { vm.addToCart() }
    }

    override fun createViewModel(): BookViewModel {
        val bookId = requireArguments().getString(BOOK_ID_KEY) ?: throw BookStoreException()
        return BookStoreApp.instance.locator.createBookViewModel(bookId)
    }

    override fun bindViewModel() {
        super.bindViewModel()
        vm.book.observe(this, Observer { showBook(it) })
        vm.favorite.observe(this, Observer { showFavorite(it) })
    }

    private fun showBook(book: Book) {
        nameView.text = book.name
        authorView.text = book.authorName
        authorView.setOnClickListener { openAuthor(book.authorId) }
        descriptionView.text = book.description
        genreView.text = book.genre
        publisherView.text = book.publisherName
        publisherView.setOnClickListener { openPublisher(book.publisherId) }
        priceView.text = resources.getString(R.string.price_format).format(book.price.toPlainString())
    }

    private fun openAuthor(id: String) {
        findNavController().navigate(R.id.authorScreen, AuthorFragment.createArgs(id))
    }

    private fun openPublisher(id: String) {
        findNavController().navigate(R.id.publisherScreen, PublisherFragment.createArgs(id))
    }

    private fun showFavorite(favorite: Boolean) {
        val favoriteTextResource = if (favorite) R.string.remove_from_favorites else R.string.add_to_favorites
        val favoriteIconResource = if (favorite) R.drawable.ic_star_filled else R.drawable.ic_star_empty
        favoriteView.setText(favoriteTextResource)
        favoriteView.setCompoundDrawablesWithIntrinsicBounds(0, favoriteIconResource, 0, 0)
    }

    companion object {
        private const val BOOK_ID_KEY = "BOOK_ID_KEY"
        fun createArgs(bookId: String) = bundleOf(BOOK_ID_KEY to bookId)
    }
}