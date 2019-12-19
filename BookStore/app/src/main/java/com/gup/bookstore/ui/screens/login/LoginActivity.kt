package com.gup.bookstore.ui.screens.login

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import com.gup.bookstore.BookStoreApp
import com.gup.bookstore.R
import com.gup.bookstore.ui.base.BaseActivity
import com.gup.bookstore.ui.screens.main.MainActivity
import com.gup.domain.exceptions.BookStoreException
import kotlinx.android.synthetic.main.activity_login.*
import javax.security.auth.login.LoginException

class LoginActivity : BaseActivity<LoginViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginButton.setOnClickListener { login() }
    }

    override fun createViewModel() = BookStoreApp.instance.locator.createLoginViewModel()

    override fun bindViewModel() {
        super.bindViewModel()
        vm.savedUserId.observe(this, Observer { processSavingIdResult(it) })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == SIGN_IN_RESULT_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                vm.saveUserId(FirebaseAuth.getInstance().currentUser?.uid ?: throw BookStoreException())
            } else {
                vm.error.value = LoginException()
            }
        }
    }

    private fun login() {
        val providers = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build(),
            AuthUI.IdpConfig.GoogleBuilder().build()
        )
        startActivityForResult(
            AuthUI
                .getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers).build(),
            SIGN_IN_RESULT_CODE
        )
    }

    private fun processSavingIdResult(loggedIn: Boolean) {
        if (loggedIn) startActivity(MainActivity.getIntent(this))
    }

    companion object {
        private const val SIGN_IN_RESULT_CODE = 9001
        fun getIntent(context: Context?): Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }
}