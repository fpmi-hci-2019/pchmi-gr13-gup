package com.gup.domain.repositories

interface OrderRepository {
    fun saveOrder(userId: String, booksIds: Set<String>)
    fun loadOrder(userId: String): Set<String>?
    fun eraseOrder(userId: String)
}