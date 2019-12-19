package com.gup.bookstore.ui.screens.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import com.gup.bookstore.BookStoreApp
import com.gup.bookstore.R
import com.gup.bookstore.ui.base.BaseActivity
import com.gup.bookstore.ui.screens.main.MainActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity<LoginViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginButton.setOnClickListener { login() }
    }

    override fun createViewModel() = BookStoreApp.instance.locator.createLoginViewModel()

    override fun bindViewModel() {
        super.bindViewModel()
        vm.loggedIn.observe(this, Observer { processLoginResult(it) })
    }

    private fun login() {
        vm.login(emailEditView.text.toString(), passwordEditView.text.toString())
    }

    private fun processLoginResult(loggedIn: Boolean) {
        if (loggedIn) startActivity(MainActivity.getIntent(this))
    }

    companion object {
        fun getIntent(context: Context?): Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }
}