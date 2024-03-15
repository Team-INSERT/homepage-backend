package com.teaminsert.homepage.domain.user.presentation

import com.teaminsert.homepage.domain.auth.presentation.dto.req.AccessTokenRequest
import com.teaminsert.homepage.domain.auth.presentation.dto.req.RefreshTokenRequest
import com.teaminsert.homepage.domain.user.service.GoogleAuthService
import com.teaminsert.homepage.domain.user.service.GoogleLinkService
import com.teaminsert.homepage.domain.user.service.LogoutService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@Tag(name = "google API")
@RequestMapping("/google")
@RestController
class GoogleController(
        private val googleLinkService: GoogleLinkService,
        private val googleAuthService: GoogleAuthService,
        private val logoutService: LogoutService
) {
    @Operation(summary = "구글 로그인 링크")
    @GetMapping
    fun getGoogleAuthLink() = googleLinkService.execute()

    @Operation(summary = "token 발급")
    @PostMapping
    fun login(@RequestBody @Valid accessTokenRequest: AccessTokenRequest)
        = googleAuthService.execute(accessTokenRequest.accessToken)

    @Operation(summary = "refreshToken 제거")
    @DeleteMapping
    fun logout(@RequestBody refreshTokenRequest: RefreshTokenRequest)
        = logoutService.execute(refreshTokenRequest.refreshToken)
}