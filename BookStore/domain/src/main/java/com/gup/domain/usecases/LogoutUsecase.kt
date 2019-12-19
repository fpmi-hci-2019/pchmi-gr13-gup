package com.gup.domain.usecases

import com.gup.domain.usecases.base.SuspendUsecase

interface LogoutUsecase : SuspendUsecase<LogoutUsecase.Params, Unit> {
    class Params
}