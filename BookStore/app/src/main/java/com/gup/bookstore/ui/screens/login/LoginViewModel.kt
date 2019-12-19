package com.gup.bookstore.ui.screens.login

import androidx.lifecycle.MutableLiveData
import com.gup.bookstore.ui.base.BaseViewModel
import com.gup.domain.usecases.SaveUserIdUsecase

class LoginViewModel(private val saveSaveUserIdUsecase: SaveUserIdUsecase) : BaseViewModel() {
    val savedUserId = MutableLiveData<Boolean>()

    fun saveUserId(userId: String) {
        launchExplicitly {
            saveSaveUserIdUsecase.execute(SaveUserIdUsecase.Params(userId))
            savedUserId.value = true
        }
    }
}