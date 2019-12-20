package com.gup.domain.entities

class Book(
    val id: String,
    val name: String,
    val authorId: String,
    val authorName: String,
    val description: String,
    val genre: String,
    val publisherId: String,
    val publisherName: String,
    val price: Double
) {
    constructor() : this(
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        0.0
    )
}