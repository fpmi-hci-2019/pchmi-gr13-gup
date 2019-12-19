package com.gup.domain.usecases

import com.gup.domain.usecases.base.SuspendUsecase

interface LoadOrderQuantityUsecase : SuspendUsecase<LoadOrderQuantityUsecase.Params, Int> {
    class Params
}