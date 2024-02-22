package com.teaminsert.homepage.domain.user.service

import com.teaminsert.homepage.global.config.properties.AuthProperties
import org.springframework.stereotype.Service

@Service
class GoogleLinkService(
        private val authProperties: AuthProperties
) {
    private val QUERY_STRING: String = "?client_id=%s&redirect_uri=%s" +
            "&response_type=token&scope=https://www.googleapis.com/auth/userinfo.email https://www.googleapis.com/auth/userinfo.profile"

    fun execute() = authProperties.google.baseUrl +
            String.format(
                    QUERY_STRING,
                    authProperties.google.clientId,
                    authProperties.google.redirectUrl)
}
