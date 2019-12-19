package com.gup.domain.usecases

import com.gup.domain.usecases.base.SuspendUsecase

interface SaveUserIdUsecase : SuspendUsecase<SaveUserIdUsecase.Params, Unit> {
    class Params(val userId: String)
}