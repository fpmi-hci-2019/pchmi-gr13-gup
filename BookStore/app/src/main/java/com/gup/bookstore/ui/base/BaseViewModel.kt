package com.gup.bookstore.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    val loading = MutableLiveData<Boolean>()
    val error = MutableLiveData<Throwable>()

    protected fun launchExplicitly(f: suspend () -> Unit): Job {
        return uiScope.launch {
            try {
                loading.value = true
                f()
            } catch (error: Throwable) {
                this@BaseViewModel.error.value = error
            } finally {
                loading.value = false
            }
        }
    }

    protected fun launchImplicitly(f: suspend () -> Unit): Job {
        return uiScope.launch {
            try {
                f()
            } catch (error: Throwable) {
                this@BaseViewModel.error.value = error
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}