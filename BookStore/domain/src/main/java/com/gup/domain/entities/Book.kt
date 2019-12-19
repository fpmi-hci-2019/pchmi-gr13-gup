package com.gup.domain.entities

import java.math.BigDecimal

class Book(
    val id: String,
    val name: String,
    val authorId: String,
    val authorName: String,
    val description: String,
    val genre: String,
    val publisherId: String,
    val publisherName: String,
    val price: BigDecimal
)