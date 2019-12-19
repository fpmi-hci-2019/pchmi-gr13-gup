package com.gup.bookstore.ui.screens.main.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.gup.bookstore.BookStoreApp
import com.gup.bookstore.R
import com.gup.bookstore.ui.base.BaseFragment
import com.gup.bookstore.ui.screens.login.LoginActivity
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : BaseFragment<ProfileViewModel>() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logoutButton.setOnClickListener { vm.logout() }
    }

    override fun createViewModel() = BookStoreApp.instance.locator.createProfileViewModel()

    override fun bindViewModel() {
        super.bindViewModel()
        vm.loggedOut.observe(this, Observer { processLogoutResult(it) })
    }

    private fun processLogoutResult(loggedOut: Boolean) {
        if (loggedOut) with(requireActivity()) {
            finishAffinity()
            startActivity(LoginActivity.getIntent(context))
        }
    }
}