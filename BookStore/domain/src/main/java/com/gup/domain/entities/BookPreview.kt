package com.gup.domain.entities

class BookPreview(
    val id: String,
    val name: String,
    val author: String,
    val price: Double
) {
    constructor() : this(
        "",
        "",
        "",
        0.0
    )
}