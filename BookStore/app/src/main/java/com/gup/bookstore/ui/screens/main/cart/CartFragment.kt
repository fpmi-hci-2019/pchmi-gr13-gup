package com.gup.bookstore.ui.screens.main.cart

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
import com.gup.bookstore.ui.screens.main.MainActivity
import com.gup.bookstore.ui.screens.main.cart.adapter.OrderedBookPreviewsAdapter
import com.gup.domain.entities.BookPreview
import kotlinx.android.synthetic.main.fragment_cart.*

class CartFragment : BaseFragment<CartViewModel>() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(orderedBookPreviewsView) {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = OrderedBookPreviewsAdapter(
                { openBook(it.id) },
                { removeBookFromOrder(it.id) }
            )
            addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
        }
    }

    override fun onResume() {
        super.onResume()
        vm.updateOrder()
    }

    override fun createViewModel() = BookStoreApp.instance.locator.createCartViewModel()

    override fun bindViewModel() {
        super.bindViewModel()
        vm.orderedBookPreviews.observe(this, Observer {
            showBookPreviews(it)
            (activity as MainActivity).updateOrderQuantity()
        })
        vm.orderPrice.observe(this, Observer { showOrderPrice(it) })
    }

    private fun openBook(id: String) {
        startActivity(BookListActivity.getIntent(context, id))
    }

    private fun removeBookFromOrder(id: String) {
        vm.removeBookFromOrder(id)
    }

    private fun showBookPreviews(booksPreviews: List<BookPreview>) {
        with(orderedBookPreviewsView.adapter as OrderedBookPreviewsAdapter) {
            items.clear()
            items.addAll(booksPreviews)
            notifyDataSetChanged()
        }
    }

    private fun showOrderPrice(price: Double) {
        orderPriceView.text = resources.getString(R.string.total_price_format).format(price)
    }
}