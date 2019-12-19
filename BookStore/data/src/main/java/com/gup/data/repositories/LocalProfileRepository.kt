package com.gup.data.repositories

import com.gup.domain.exceptions.CredentialsException
import com.gup.domain.repositories.PreferencesRepository
import com.gup.domain.repositories.ProfileRepository

class LocalProfileRepository(private val preferencesRepository: PreferencesRepository) : ProfileRepository {
    override fun login(email: String, password: String): String {
        return when {
            email == "Biba" && password == "123456" -> "userId1"
            email == "Boba" && password == "654321" -> "userId2"
            else -> throw CredentialsException()
        }
    }

    override fun saveUserId(userId: String) {
        preferencesRepository.saveString(USER_ID_KEY, userId)
    }

    override fun loadUserId(): String? {
        return preferencesRepository.loadString(USER_ID_KEY)
    }

    override fun eraseUserId() {
        return preferencesRepository.eraseValue(USER_ID_KEY)
    }

    companion object {
        const val PREFS_PROFILE_NAME = "PREFS_PROFILE_NAME"
        private const val USER_ID_KEY = "USER_ID_KEY"
    }
}