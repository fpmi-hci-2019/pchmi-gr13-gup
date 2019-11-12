package com.gup.domain.usecases.rx

import com.gup.domain.usecases.base.Usecase
import io.reactivex.Flowable

interface FlowableUsecase<P, T> : Usecase<P, Flowable<T>> {
    override fun execute(params: P): Flowable<T>
}