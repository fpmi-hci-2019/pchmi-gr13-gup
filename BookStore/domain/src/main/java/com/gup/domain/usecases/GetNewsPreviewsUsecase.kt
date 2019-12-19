package com.gup.domain.usecases

import com.gup.domain.entities.NewsPreview
import com.gup.domain.usecases.base.SuspendUsecase

interface GetNewsPreviewsUsecase : SuspendUsecase<GetNewsPreviewsUsecase.Params, List<NewsPreview>> {
    class Params
}