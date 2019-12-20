package com.gup.domain.entities

class Publisher(
    val id: String,
    val name: String,
    val description: String,
    val address: String
) {
    constructor() : this(
        "",
        "",
        "",
        ""
    )
}