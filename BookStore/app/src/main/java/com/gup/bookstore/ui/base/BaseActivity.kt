package com.gup.bookstore.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer

abstract class BaseActivity<U : BaseContract.UI, V : BaseContract.ViewModel<U>> :
    AppCompatActivity(),
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

    override fun onStart() {
        super.onStart()
        bindViewModel()
    }
}