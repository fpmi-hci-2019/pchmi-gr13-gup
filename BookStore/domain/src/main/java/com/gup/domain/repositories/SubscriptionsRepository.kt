package com.gup.domain.repositories

interface SubscriptionsRepository {
    fun saveSubscriptions(userId: String, subscriptionsIds: Set<String>)
    fun loadSubscriptions(userId: String): Set<String>?
    fun eraseSubscriptions(userId: String)
}