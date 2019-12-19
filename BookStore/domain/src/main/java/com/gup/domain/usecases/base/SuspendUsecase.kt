package com.gup.domain.usecases.base

interface SuspendUsecase<P, R> {
    suspend fun execute(params: P) : R
}