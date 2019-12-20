package com.gup.domain.usecases

import com.gup.domain.usecases.base.SuspendUsecase

interface CheckoutOrderUsecase : SuspendUsecase<CheckoutOrderUsecase.Params, Unit> {
    class Params
}