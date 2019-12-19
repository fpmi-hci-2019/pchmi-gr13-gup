package com.gup.domain.usecases

import com.gup.domain.usecases.base.SuspendUsecase

interface RemoveFavoriteUsecase : SuspendUsecase<RemoveFavoriteUsecase.Params, Unit> {
    class Params(val bookId: String)
}