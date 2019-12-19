package com.gup.domain.usecases

import com.gup.domain.repositories.ProfileRepository

class LoginUsecaseImpl(
    private val profileRepository: ProfileRepository
) : LoginUsecase {
    override suspend fun execute(params: LoginUsecase.Params) {
        val userId = profileRepository.login(params.email, params.password)
        profileRepository.saveUserId(userId)
    }
}