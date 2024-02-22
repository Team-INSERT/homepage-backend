package com.teaminsert.homepage.domain.auth.presentation.dto.req

import jakarta.validation.constraints.NotNull

class RefreshTokenRequest(
        @NotNull
        val refreshToken: String
) {
}