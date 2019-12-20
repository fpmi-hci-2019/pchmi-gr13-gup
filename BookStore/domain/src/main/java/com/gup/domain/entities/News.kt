package com.gup.domain.entities

class News(
    val id: String,
    val title: String,
    val text: String,
    val date: String,
    val publisherId: String,
    val publisherName: String
) {
    constructor() : this(
        "",
        "",
        "",
        "",
        "",
        ""
    )
}