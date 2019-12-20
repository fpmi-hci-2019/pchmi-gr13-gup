package com.gup.bookstore.ui.screens.main.cart

import androidx.lifecycle.MutableLiveData
import com.gup.bookstore.ui.base.BaseViewModel
import com.gup.domain.entities.BookPreview
import com.gup.domain.exceptions.BookStoreException
import com.gup.domain.usecases.CheckoutOrderUsecase
import com.gup.domain.usecases.LoadOrderUsecase
import com.gup.domain.usecases.RemoveBookFromOrderUsecase

class CartViewModel(
    private val loadOrderUsecase: LoadOrderUsecase,
    private val removeBookFromOrderUsecase: RemoveBookFromOrderUsecase,
    private val checkoutOrderUsecase: CheckoutOrderUsecase
) : BaseViewModel() {
    val orderedBookPreviews = MutableLiveData<List<BookPreview>>()
    val orderPrice = MutableLiveData<Double>()

    fun updateOrder() {
        launchExplicitly {
            orderedBookPreviews.value = ArrayList(loadOrderUsecase.execute(LoadOrderUsecase.Params()))
            orderPrice.value = orderedBookPreviews.value.totalPrice()
        }
    }

    fun removeBookFromOrder(id: String) {
        launchExplicitly {
            removeBookFromOrderUsecase.execute(RemoveBookFromOrderUsecase.Params(id))
            val element = orderedBookPreviews.value?.first { it.id == id } ?: throw BookStoreException()
            orderedBookPreviews.value = orderedBookPreviews.value?.minus(element)
            orderPrice.value = orderPrice.value?.minus(element.price)
        }
    }

    fun checkoutOrder() {
        launchExplicitly {
            checkoutOrderUsecase.execute(CheckoutOrderUsecase.Params())
            orderedBookPreviews.value = emptyList()
            orderPrice.value = 0.0
        }
    }

    private fun List<BookPreview>?.totalPrice(): Double {
        var totalPrice = 0.0
        this?.forEach { totalPrice += it.price }
        return totalPrice
    }
}