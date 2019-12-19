package com.gup.domain.usecases

import com.gup.domain.usecases.base.SuspendUsecase

interface AddSubscriptionUsecase: SuspendUsecase<AddSubscriptionUsecase.Params, Unit> {
    class Params(val publisherId: String)
}