package com.gup.domain.usecases

import com.gup.domain.entities.BookPreview
import com.gup.domain.usecases.base.SuspendUsecase

interface LoadOrderUsecase : SuspendUsecase<LoadOrderUsecase.Params, List<BookPreview>> {
    class Params
}