package com.gup.domain.usecases

import com.gup.domain.usecases.base.SuspendUsecase

interface LoginUsecase : SuspendUsecase<LoginUsecase.Params, Unit> {
    class Params(val email: String, val password: String)
}