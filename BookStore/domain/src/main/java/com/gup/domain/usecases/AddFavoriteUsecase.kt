package com.gup.domain.usecases

import com.gup.domain.usecases.base.SuspendUsecase

interface AddFavoriteUsecase : SuspendUsecase<AddFavoriteUsecase.Params, Unit> {
    class Params(val bookId: String)
}