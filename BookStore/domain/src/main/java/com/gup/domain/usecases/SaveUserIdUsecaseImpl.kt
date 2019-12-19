package com.gup.domain.usecases

import com.gup.domain.repositories.ProfileRepository

class SaveUserIdUsecaseImpl(private val profileRepository: ProfileRepository) : SaveUserIdUsecase {
    override suspend fun execute(params: SaveUserIdUsecase.Params) {
        profileRepository.saveUserId(params.userId)
    }
}