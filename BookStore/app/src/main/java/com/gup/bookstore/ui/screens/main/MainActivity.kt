package com.gup.bookstore.ui.screens.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.gup.bookstore.BookStoreApp
import com.gup.bookstore.R
import com.gup.bookstore.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        bottomNavigation.setupWithNavController(findNavController(R.id.nav_host_fragment))
    }

    override fun onResume() {
        super.onResume()
        updateOrderQuantity()
    }

    override fun createViewModel() = BookStoreApp.instance.locator.createMainViewModel()

    override fun bindViewModel() {
        super.bindViewModel()
        vm.orderQuantity.observe(this, Observer { showOrderQuantity(it) })
    }

    fun updateOrderQuantity() {
        vm.updateOrderQuantity()
    }

    private fun showOrderQuantity(orderQuantity: Int) {
        if (orderQuantity > 0) {
            bottomNavigation.getOrCreateBadge(R.id.cartScreen).number = orderQuantity
        } else {
            bottomNavigation.removeBadge(R.id.cartScreen)
        }
    }

    companion object {
        fun getIntent(context: Context?): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }
}
