package com.gup.data.repositories

import com.gup.domain.repositories.OrderRepository
import com.gup.domain.repositories.PreferencesRepository

class LocalOrderRepositoryImpl(private val preferencesRepository: PreferencesRepository) : OrderRepository {
    override fun saveOrder(userId: String, booksIds: Set<String>) {
        preferencesRepository.saveStringSet(userId, booksIds)
    }

    override fun loadOrder(userId: String): Set<String>? {
        return preferencesRepository.loadStringSet(userId)
    }

    override fun eraseOrder(userId: String) {
        preferencesRepository.eraseValue(userId)
    }

    companion object {
        const val PREFS_ORDER_NAME ="PREFS_ORDER_NAME"
    }
}