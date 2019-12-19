package com.gup.data.repositories

import com.gup.domain.repositories.PreferencesRepository
import com.gup.domain.repositories.SubscriptionsRepository

class LocalSubscriptionsRepositoryImpl(private val preferencesRepository: PreferencesRepository) : SubscriptionsRepository {
    override fun saveSubscriptions(userId: String, subscriptionsIds: Set<String>) {
        preferencesRepository.saveStringSet(userId, subscriptionsIds)
    }

    override fun loadSubscriptions(userId: String): Set<String>? {
        return preferencesRepository.loadStringSet(userId)
    }

    override fun eraseSubscriptions(userId: String) {
        preferencesRepository.eraseValue(userId)
    }

    companion object {
        const val PREFS_SUBSCRIPTIONS_NAME = "PREFS_SUBSCRIPTIONS_NAME"
    }
}