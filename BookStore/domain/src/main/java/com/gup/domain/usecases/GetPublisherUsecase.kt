package com.gup.domain.usecases

import com.gup.domain.entities.Publisher
import com.gup.domain.usecases.base.SuspendUsecase

interface GetPublisherUsecase : SuspendUsecase<GetPublisherUsecase.Params, Pair<Publisher, Boolean>> {
    class Params(val id: String)
}