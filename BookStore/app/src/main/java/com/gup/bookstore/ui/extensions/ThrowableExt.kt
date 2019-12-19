package com.gup.bookstore.ui.extensions

import android.content.res.Resources
import com.gup.bookstore.R
import com.gup.domain.exceptions.BookStoreException
import com.gup.domain.exceptions.CredentialsException

fun Throwable.toMessage(resources: Resources): String {
    return when (this) {
        is BookStoreException -> resources.getString(R.string.unexpected_error)
        is CredentialsException -> resources.getString(R.string.invalid_credentials)
        else -> resources.getString(R.string.unexpected_error)
    }
}