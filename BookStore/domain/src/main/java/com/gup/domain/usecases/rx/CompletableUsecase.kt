package com.gup.domain.usecases.rx

import com.gup.domain.usecases.base.Usecase
import io.reactivex.Completable

interface CompletableUsecase<P> : Usecase<P, Completable> {
    override fun execute(params: P): Completable
}