package com.gup.bookstore

import android.app.Application

class BookStoreApp : Application() {

    val locator: ServiceLocator by lazy { ServiceLocator(this) }

    companion object {
        lateinit var instance: BookStoreApp
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}