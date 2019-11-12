package com.gup.bookstore.ui.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer

abstract class BaseFragment<U : BaseContract.UI, V : BaseContract.ViewModel<U>> :
    Fragment(),
    BaseContract.UI {

    protected lateinit var vm: V

    abstract fun createViewModel(): V

    open fun bindViewModel() {
        vm.loading.observe(this, Observer {
            // TODO: implement showing progressbar
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = createViewModel()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViewModel()
    }
}