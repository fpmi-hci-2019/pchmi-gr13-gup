package com.gup.domain.usecases

import com.gup.domain.entities.News
import com.gup.domain.usecases.base.SuspendUsecase

interface GetNewsUsecase : SuspendUsecase<GetNewsUsecase.Params, News> {
    class Params(val id: String)
}