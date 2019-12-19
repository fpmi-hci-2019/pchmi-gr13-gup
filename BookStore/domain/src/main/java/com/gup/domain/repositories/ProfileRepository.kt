package com.gup.domain.repositories

interface ProfileRepository {
    fun login(email: String, password: String): String
    fun saveUserId(userId: String)
    fun loadUserId() : String?
    fun eraseUserId()
}