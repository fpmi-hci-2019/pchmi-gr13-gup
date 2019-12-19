package com.gup.bookstore.ui.screens.publisher

import androidx.lifecycle.MutableLiveData
import com.gup.bookstore.ui.base.BaseViewModel
import com.gup.domain.entities.Publisher
import com.gup.domain.usecases.AddSubscriptionUsecase
import com.gup.domain.usecases.GetPublisherUsecase
import com.gup.domain.usecases.RemoveSubscriptionUsecase

class PublisherViewModel(
    private val publisherId: String,
    private val getPublisherUsecase: GetPublisherUsecase,
    private val addSubscriptionUsecase: AddSubscriptionUsecase,
    private val removeSubscriptionUsecase: RemoveSubscriptionUsecase
) : BaseViewModel() {
    val publisher = MutableLiveData<Publisher>()
    val subscribed = MutableLiveData<Boolean>()

    init {
        launchExplicitly {
            val getPublisherResult = getPublisherUsecase.execute(GetPublisherUsecase.Params(publisherId))
            publisher.value = getPublisherResult.first
            subscribed.value = getPublisherResult.second
        }
    }

    fun changeSubscribed() {
        launchExplicitly {
            if (subscribed.value == true) {
                subscribed.value = false
                removeSubscriptionUsecase.execute(RemoveSubscriptionUsecase.Params(publisherId))
            } else {
                subscribed.value = true
                addSubscriptionUsecase.execute(AddSubscriptionUsecase.Params(publisherId))
            }
        }
    }
}