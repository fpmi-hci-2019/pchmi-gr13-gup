package com.gup.bookstore.ui.screens.main

import androidx.lifecycle.MutableLiveData
import com.gup.bookstore.ui.base.BaseViewModel
import com.gup.domain.usecases.LoadOrderQuantityUsecase

class MainViewModel(
    private val loadOrderQuantityUsecase: LoadOrderQuantityUsecase
) : BaseViewModel() {
    val orderQuantity = MutableLiveData<Int>()

    fun updateOrderQuantity() {
        launchImplicitly {
            orderQuantity.value = loadOrderQuantityUsecase.execute(LoadOrderQuantityUsecase.Params())
        }
    }
}