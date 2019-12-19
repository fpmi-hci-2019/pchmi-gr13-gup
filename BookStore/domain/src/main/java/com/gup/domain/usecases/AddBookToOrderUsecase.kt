package com.gup.domain.usecases

import com.gup.domain.usecases.base.SuspendUsecase

interface AddBookToOrderUsecase : SuspendUsecase<AddBookToOrderUsecase.Params, Unit> {
    class Params(val bookId: String)
}