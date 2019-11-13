package com.gup.domain.usecases.base

interface Usecase<P, R> {
    fun execute(params: P) : R
}