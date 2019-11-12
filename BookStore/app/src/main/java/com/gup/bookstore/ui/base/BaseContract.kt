package com.gup.bookstore.ui.base

import androidx.lifecycle.LiveData

interface BaseContract {
    interface UI

    interface ViewModel<U : UI> {
        val loading: LiveData<Boolean>
    }

    interface Args
}