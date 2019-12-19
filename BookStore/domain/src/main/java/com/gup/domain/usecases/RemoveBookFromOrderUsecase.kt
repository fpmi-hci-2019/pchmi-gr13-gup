package com.gup.domain.usecases

import com.gup.domain.usecases.base.SuspendUsecase

interface RemoveBookFromOrderUsecase: SuspendUsecase<RemoveBookFromOrderUsecase.Params, Unit> {
    class Params(val bookId: String)
}