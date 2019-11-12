package com.gup.bookstore.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<U : BaseContract.UI, A : BaseContract.Args>(protected val args: A) :
    ViewModel(), BaseContract.ViewModel<U> {

    override val loading: LiveData<Boolean> = MutableLiveData<Boolean>()
}