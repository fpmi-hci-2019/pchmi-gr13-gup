package com.gup.bookstore.ui.screens.publisher

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import com.gup.bookstore.BookStoreApp
import com.gup.bookstore.R
import com.gup.bookstore.ui.base.BaseFragment
import com.gup.domain.entities.Publisher
import com.gup.domain.exceptions.BookStoreException
import kotlinx.android.synthetic.main.fragment_publisher.*

class PublisherFragment : BaseFragment<PublisherViewModel>() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_publisher, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribedView.setOnClickListener { vm.changeSubscribed() }
    }

    override fun createViewModel() : PublisherViewModel {
        val publisherId = requireArguments().getString(PUBLISHER_ID_KEY) ?: throw BookStoreException()
        return BookStoreApp.instance.locator.createPublisherViewModel(publisherId)
    }

    override fun bindViewModel() {
        super.bindViewModel()
        vm.publisher.observe(this, Observer { showPublisher(it) })
        vm.subscribed.observe(this, Observer { showSubscribed(it) })
    }

    private fun showPublisher(publisher: Publisher) {
        nameView.text = publisher.name
        descriptionView.text = publisher.description
        addressView.text = publisher.address
    }

    private fun showSubscribed(subscribed: Boolean) {
        val subscribedTextResource = if (subscribed) R.string.unsubscribe_from_news else R.string.subscribe_to_news
        val subscribedIconResource = if (subscribed) R.drawable.ic_star_filled else R.drawable.ic_star_empty
        subscribedView.setText(subscribedTextResource)
        subscribedView.setCompoundDrawablesWithIntrinsicBounds(0, subscribedIconResource, 0, 0)
    }

    companion object {
        private const val PUBLISHER_ID_KEY = "PUBLISHER_ID_KEY"
        fun createArgs(publisherId: String) = bundleOf(PUBLISHER_ID_KEY to publisherId)
    }
}