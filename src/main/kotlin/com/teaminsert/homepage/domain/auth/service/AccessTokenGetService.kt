package com.teaminsert.homepage.domain.auth.service

import com.teaminsert.homepage.domain.auth.domain.RefreshToken
import com.teaminsert.homepage.domain.auth.domain.repository.RefreshTokenRepository
import com.teaminsert.homepage.domain.auth.presentation.dto.res.AccessTokenResponse
import com.teaminsert.homepage.global.security.jwt.JwtTokenProvider
import com.teaminsert.homepage.global.security.jwt.exception.ExpiredJwtException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AccessTokenGetService(
        private val refreshTokenRepository: RefreshTokenRepository,
        private val jwtTokenProvider: JwtTokenProvider
) {
    @Transactional(readOnly = true)
    fun execute(token: String): AccessTokenResponse {
        val refreshToken: RefreshToken = getRefreshToken(token)
        return AccessTokenResponse(
                jwtTokenProvider.createAccessToken(refreshToken.email))
    }

    fun getRefreshToken(token: String)
        = refreshTokenRepository.findByIdOrNull(token)
            ?: throw ExpiredJwtException.EXCEPTION
}