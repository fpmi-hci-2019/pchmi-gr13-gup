package com.gup.domain.usecases

import com.gup.domain.usecases.base.SuspendUsecase

interface RemoveSubscriptionUsecase: SuspendUsecase<RemoveSubscriptionUsecase.Params, Unit> {
    class Params(val publisherId: String)
}