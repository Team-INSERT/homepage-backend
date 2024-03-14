package com.teaminsert.homepage.domain.auth.presentation

import com.teaminsert.homepage.domain.auth.presentation.dto.req.RefreshTokenRequest
import com.teaminsert.homepage.domain.auth.service.AccessTokenGetService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "auth API")
@RequestMapping("/auth")
@RestController
class AuthController(
        private val accessTokenGetService: AccessTokenGetService
) {
    @Operation(summary = "accessToken 재발급")
    @PostMapping
    fun createNewAccessToken(@RequestBody @Valid request: RefreshTokenRequest)
        = accessTokenGetService.execute(request.refreshToken)
}