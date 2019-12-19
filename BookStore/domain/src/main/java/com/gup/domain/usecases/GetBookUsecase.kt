package com.gup.domain.usecases

import com.gup.domain.entities.Book
import com.gup.domain.usecases.base.SuspendUsecase

interface GetBookUsecase : SuspendUsecase<GetBookUsecase.Params, Pair<Book, Boolean>> {
    class Params(val id: String)
}