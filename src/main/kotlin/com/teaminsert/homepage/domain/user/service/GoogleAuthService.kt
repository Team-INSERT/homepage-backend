package com.teaminsert.homepage.domain.user.service

import com.teaminsert.homepage.domain.auth.presentation.dto.res.TokenResponse
import com.teaminsert.homepage.domain.user.domain.User
import com.teaminsert.homepage.domain.user.domain.repository.UserRepository
import com.teaminsert.homepage.domain.user.domain.type.Authority
import com.teaminsert.homepage.domain.user.exception.SchoolUserNotException
import com.teaminsert.homepage.global.feign.auth.GoogleInformationClient
import com.teaminsert.homepage.global.feign.auth.dto.res.GoogleInformationResponse
import com.teaminsert.homepage.global.security.jwt.JwtTokenProvider
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class GoogleAuthService(
        private val userRepository: UserRepository,
        private val jwtTokenProvider: JwtTokenProvider,
        private val googleInformationClient: GoogleInformationClient
) {
    @Transactional
    fun execute(accessToken: String): TokenResponse {
        val response: GoogleInformationResponse = googleInformationClient
                .getInformation(accessToken)

        val email: String = response.email

        userRepository.findByEmail(email) ?: run {
            if (email.endsWith("@bssm.hs.kr")) {
                userRepository.save(User(email,
                        response.name,
                        if (email.startsWith("teacher")) Authority.ADMIN
                        else Authority.USER))
            } else {
                throw SchoolUserNotException.EXCEPTION
            }
        }

        return TokenResponse(
                jwtTokenProvider.createAccessToken(email),
                jwtTokenProvider.createRefreshToken(email)
        )
    }
}