package com.gup.bookstore.ui.screens.login

import androidx.lifecycle.MutableLiveData
import com.gup.bookstore.ui.base.BaseViewModel
import com.gup.domain.usecases.LoginUsecase

class LoginViewModel(private val loginUsecase: LoginUsecase) : BaseViewModel() {
    val loggedIn = MutableLiveData<Boolean>()

    fun login(email: String, password: String) {
        launchExplicitly {
            loginUsecase.execute(LoginUsecase.Params(email, password))
            loggedIn.value = true
        }
    }
}