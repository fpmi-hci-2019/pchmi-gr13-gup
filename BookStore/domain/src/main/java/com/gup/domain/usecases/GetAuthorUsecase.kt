package com.gup.domain.usecases

import com.gup.domain.entities.Author
import com.gup.domain.usecases.base.SuspendUsecase

interface GetAuthorUsecase : SuspendUsecase<GetAuthorUsecase.Params, Author> {
    class Params(val id: String)
}