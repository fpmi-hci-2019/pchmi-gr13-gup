package com.gup.domain.usecases.rx

import com.gup.domain.usecases.base.Usecase
import io.reactivex.Single

interface SingleUsecase<P, T> : Usecase<P, Single<T>> {
    override fun execute(params: P): Single<T>
}