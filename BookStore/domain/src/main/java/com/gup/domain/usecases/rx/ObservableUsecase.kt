package com.gup.domain.usecases.rx

import com.gup.domain.usecases.base.Usecase
import io.reactivex.Observable

interface ObservableUsecase<P, T> : Usecase<P, Observable<T>> {
    override fun execute(params: P): Observable<T>
}