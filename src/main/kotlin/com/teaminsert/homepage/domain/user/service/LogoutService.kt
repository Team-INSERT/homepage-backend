package com.teaminsert.homepage.domain.user.service

import com.teaminsert.homepage.domain.auth.domain.repository.RefreshTokenRepository
import org.springframework.stereotype.Service

@Service
class LogoutService(
        private val refreshTokenRepository: RefreshTokenRepository
) {
    fun execute(refreshToken: String)
        = refreshTokenRepository.deleteById(refreshToken)
}