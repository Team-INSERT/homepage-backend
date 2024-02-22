package com.teaminsert.homepage.domain.user.presentation

import com.teaminsert.homepage.domain.auth.presentation.dto.req.AccessTokenRequest
import com.teaminsert.homepage.domain.user.service.GoogleAuthService
import com.teaminsert.homepage.domain.user.service.GoogleLinkService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RequestMapping("/google")
@RestController
class GoogleController(
        private val googleLinkService: GoogleLinkService,
        private val googleAuthService: GoogleAuthService
) {
    @GetMapping
    fun getGoogleAuthLink() = googleLinkService.execute()

    @PostMapping
    fun login(@RequestBody @Valid accessTokenRequest: AccessTokenRequest)
        = googleAuthService.execute(accessTokenRequest.accessToken)
}