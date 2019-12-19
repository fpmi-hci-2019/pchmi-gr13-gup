package com.gup.bookstore.ui.screens.main.profile

import androidx.lifecycle.MutableLiveData
import com.gup.bookstore.ui.base.BaseViewModel
import com.gup.domain.usecases.LogoutUsecase

class ProfileViewModel(private val logoutUsecase: LogoutUsecase) : BaseViewModel() {
    val loggedOut = MutableLiveData<Boolean>()

    fun logout() {
        launchExplicitly {
            logoutUsecase.execute(LogoutUsecase.Params())
            loggedOut.value = true
        }
    }
}