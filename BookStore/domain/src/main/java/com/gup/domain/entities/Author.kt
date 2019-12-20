package com.gup.domain.entities

class Author(
    val id: String,
    val name: String,
    val biography: String
) {
    constructor() : this(
        "",
        "",
        ""
    )
}