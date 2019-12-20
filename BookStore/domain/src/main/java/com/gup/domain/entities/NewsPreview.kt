package com.gup.domain.entities

class NewsPreview(
    val id: String,
    val text: String,
    val date: String,
    val publisherId: String
) {
    constructor() : this(
        "",
        "",
        "",
        ""
    )
}