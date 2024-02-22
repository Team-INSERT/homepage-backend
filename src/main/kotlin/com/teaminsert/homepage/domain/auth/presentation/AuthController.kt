package com.teaminsert.homepage.domain.auth.presentation

import com.teaminsert.homepage.domain.auth.presentation.dto.req.RefreshTokenRequest
import com.teaminsert.homepage.domain.auth.service.AccessTokenGetService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/auth")
@RestController
class AuthController(
        private val accessTokenGetService: AccessTokenGetService
) {
    @PostMapping
    fun createNewAccessToken(@RequestBody @Valid request: RefreshTokenRequest)
        = accessTokenGetService.execute(request.refreshToken)
}